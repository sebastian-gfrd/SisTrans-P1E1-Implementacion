package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.PUNTO_UBICACION;
import uniandes.edu.co.alpescab.modelo.CIUDAD;
import uniandes.edu.co.alpescab.repositorio.PuntoUbicacionRepository;
import uniandes.edu.co.alpescab.repositorio.CiudadRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/puntos-ubicacion")
public class PuntoUbicacionController {

    @Autowired
    private PuntoUbicacionRepository puntoUbicacionRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping
    public List<PUNTO_UBICACION> getPuntosUbicacion() {
        return puntoUbicacionRepository.findAll();
    }

    @PostMapping
    @Transactional
    public PUNTO_UBICACION addPuntoUbicacion(@RequestBody Map<String, Object> puntoData) {
        // Extract basic punto ubicacion data
        String direccionAprox = (String) puntoData.get("direccion_aprox");
        double latitud = ((Number) puntoData.get("latitud")).doubleValue();
        double longitud = ((Number) puntoData.get("longitud")).doubleValue();
        String nombreLocal = (String) puntoData.get("nombre_local");
        
        // Get CIUDAD by ID
        Map<String, Object> ciudadData = (Map<String, Object>) puntoData.get("ciudad");
        Integer idCiudad = (Integer) ciudadData.get("id_ciudad");
        CIUDAD ciudad = ciudadRepository.findById(idCiudad)
            .orElseThrow(() -> new RuntimeException("Ciudad no encontrada: " + idCiudad));
        
        // Create PUNTO_UBICACION
        PUNTO_UBICACION puntoUbicacion = new PUNTO_UBICACION();
        puntoUbicacion.setDIRECCION_APROX(direccionAprox);
        puntoUbicacion.setLATITUD(latitud);
        puntoUbicacion.setLONGITUD(longitud);
        puntoUbicacion.setNOMBRE_LOCAL(nombreLocal);
        puntoUbicacion.setCiudad(ciudad);
        
        return puntoUbicacionRepository.save(puntoUbicacion);
    }
}