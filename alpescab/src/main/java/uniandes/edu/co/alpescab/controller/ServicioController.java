package uniandes.edu.co.alpescab.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.alpescab.modelo.DISPONIBILIDAD_CONDUCTOR;
import uniandes.edu.co.alpescab.modelo.DOMICILIO_COMIDA;
import uniandes.edu.co.alpescab.modelo.PUNTO_UBICACION;
import uniandes.edu.co.alpescab.modelo.SERVICIO;
import uniandes.edu.co.alpescab.modelo.SERVICIO_MERCANCIA;
import uniandes.edu.co.alpescab.modelo.SolicitudServicioDTO;
import uniandes.edu.co.alpescab.modelo.TRANSPORTE_PASAJERO;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO;
import uniandes.edu.co.alpescab.modelo.VEHICULO;
import uniandes.edu.co.alpescab.repositorio.DisponibilidadConductorRepository;
import uniandes.edu.co.alpescab.repositorio.DomicilioComidaRepository;
import uniandes.edu.co.alpescab.repositorio.PuntoUbicacionRepository;
import uniandes.edu.co.alpescab.repositorio.ServicioMercanciaRepository;
import uniandes.edu.co.alpescab.repositorio.ServicioRepository;
import uniandes.edu.co.alpescab.repositorio.TransportePasajeroRepository;
import uniandes.edu.co.alpescab.repositorio.UsuarioServicioRepository;
import uniandes.edu.co.alpescab.repositorio.VehiculoRepository;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioServicioRepository usuarioServicioRepository;

    @Autowired
    private PuntoUbicacionRepository puntoUbicacionRepository;

    @Autowired
    private DisponibilidadConductorRepository disponibilidadConductorRepository;

    @Autowired
    private TransportePasajeroRepository transportePasajeroRepository;

    @Autowired
    private DomicilioComidaRepository domicilioComidaRepository;

    @Autowired
    private ServicioMercanciaRepository servicioMercanciaRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public List<SERVICIO> getServicios() {
        return servicioRepository.findAll();
    }

    @PostMapping("/solicitar")
    @Transactional
    public ResponseEntity<SERVICIO> solicitarServicio(@RequestBody SolicitudServicioDTO solicitud) {
        try {
            USUARIO_SERVICIO cliente = usuarioServicioRepository.findById(solicitud.getId_cliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + solicitud.getId_cliente()));
            PUNTO_UBICACION puntoPartida = puntoUbicacionRepository.findById(solicitud.getId_punto_partida())
                .orElseThrow(() -> new RuntimeException("Punto de partida no encontrado con ID: " + solicitud.getId_punto_partida()));
            PUNTO_UBICACION puntoLlegada = puntoUbicacionRepository.findById(solicitud.getId_punto_llegada())
                .orElseThrow(() -> new RuntimeException("Punto de llegada no encontrado con ID: " + solicitud.getId_punto_llegada()));

            DISPONIBILIDAD_CONDUCTOR disponibilidad = disponibilidadConductorRepository.findAvailableDriver(solicitud.getTipo_servicio());

            if (disponibilidad == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            List<VEHICULO> vehiculos = vehiculoRepository.findByIdUsuario(disponibilidad.getIdUsuarioConductor());
            VEHICULO vehiculo = vehiculos.isEmpty() ? null : vehiculos.get(0);

            // Dummy distance and cost calculation
            double distance = Math.sqrt(Math.pow(puntoLlegada.getLATITUD() - puntoPartida.getLATITUD(), 2) + Math.pow(puntoLlegada.getLONGITUD() - puntoPartida.getLONGITUD(), 2)) * 111.32;
            // Ensure distance is at least 1 to satisfy Oracle constraint CHK_SERVICIO_DIST (DISTANCIA_KM > 0)
            if (distance <= 0) {
                distance = 1.0; // Minimum distance of 1 km
            }
            int cost = (int) (distance * 1000);

            SERVICIO nuevoServicio = null;

            if ("transporte_pasajero".equals(solicitud.getTipo_servicio())) {
                Integer pasajeros = (Integer) solicitud.getDetalles_servicio().get("pasajeros");
                nuevoServicio = new TRANSPORTE_PASAJERO(solicitud.getModalidad(), (int) distance, cost, 0.1f, LocalDateTime.now(), null, vehiculo, cliente, disponibilidad.getIdUsuarioConductor(), pasajeros);
                transportePasajeroRepository.save((TRANSPORTE_PASAJERO) nuevoServicio);
            } else if ("domicilio_comida".equals(solicitud.getTipo_servicio())) {
                String numeroOrden = (String) solicitud.getDetalles_servicio().get("numero_orden");
                String detalleOrden = (String) solicitud.getDetalles_servicio().get("detalle_orden");
                String restaurante = (String) solicitud.getDetalles_servicio().get("restaurante");
                nuevoServicio = new DOMICILIO_COMIDA(solicitud.getModalidad(), (int) distance, cost, 0.1f, LocalDateTime.now(), null, vehiculo, cliente, disponibilidad.getIdUsuarioConductor(), numeroOrden, detalleOrden, restaurante);
                domicilioComidaRepository.save((DOMICILIO_COMIDA) nuevoServicio);
            } else if ("servicio_mercancia".equals(solicitud.getTipo_servicio())) {
                String descripcion = (String) solicitud.getDetalles_servicio().get("descripcion");
                Integer pesoAproximado = (Integer) solicitud.getDetalles_servicio().get("peso_aproximado");
                nuevoServicio = new SERVICIO_MERCANCIA(solicitud.getModalidad(), (int) distance, cost, 0.1f, LocalDateTime.now(), null, vehiculo, cliente, disponibilidad.getIdUsuarioConductor(), descripcion, pesoAproximado);
                servicioMercanciaRepository.save((SERVICIO_MERCANCIA) nuevoServicio);
            }

            disponibilidad.setAsignado("1");
            disponibilidadConductorRepository.save(disponibilidad);

            return new ResponseEntity<>(nuevoServicio, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/finalizar")
    @Transactional
    public ResponseEntity<SERVICIO> finalizarServicio(@PathVariable Integer id) {
        SERVICIO servicio = servicioRepository.findById(id).get();
        servicio.setHORA_FIN(LocalDateTime.now());

        DISPONIBILIDAD_CONDUCTOR disponibilidad = disponibilidadConductorRepository.findByIdUsuarioConductorAndAsignado(servicio.getConductor(), "1");
        if (disponibilidad != null) {
            disponibilidad.setAsignado("0");
            disponibilidadConductorRepository.save(disponibilidad);
        }

        servicioRepository.save(servicio);
        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }
}