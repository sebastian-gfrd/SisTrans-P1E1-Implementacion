package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.VEHICULO;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;
import uniandes.edu.co.alpescab.modelo.CIUDAD;
import uniandes.edu.co.alpescab.repositorio.VehiculoRepository;
import uniandes.edu.co.alpescab.repositorio.UsuarioConductorRepository;
import uniandes.edu.co.alpescab.repositorio.CiudadRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private UsuarioConductorRepository usuarioConductorRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping
    public List<VEHICULO> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public VEHICULO addVehiculo(@RequestBody Map<String, Object> vehiculoData) {
        // Extract basic vehicle data
        String placa = (String) vehiculoData.get("placa");
        String tipoVehiculo = (String) vehiculoData.get("tipo_vehiculo");
        String marca = (String) vehiculoData.get("marca");
        String modelo = (String) vehiculoData.get("modelo");
        String color = (String) vehiculoData.get("color");
        Integer capacidad = (Integer) vehiculoData.get("capacidad");
        
        // Get USUARIO_CONDUCTOR by ID
        Map<String, Object> usuarioData = (Map<String, Object>) vehiculoData.get("idUsuario");
        Integer idUsuario = (Integer) usuarioData.get("id_usuario");
        USUARIO_CONDUCTOR usuarioConductor = usuarioConductorRepository.findById(idUsuario)
            .orElseThrow(() -> new RuntimeException("Usuario conductor no encontrado: " + idUsuario));
        
        // Get CIUDAD by ID
        Map<String, Object> ciudadData = (Map<String, Object>) vehiculoData.get("id_ciudad");
        Integer idCiudad = (Integer) ciudadData.get("id_ciudad");
        CIUDAD ciudad = ciudadRepository.findById(idCiudad)
            .orElseThrow(() -> new RuntimeException("Ciudad no encontrada: " + idCiudad));
        
        // Create VEHICULO
        VEHICULO vehiculo = new VEHICULO(placa, tipoVehiculo, marca, modelo, color, capacidad, usuarioConductor, ciudad);
        return vehiculoRepository.save(vehiculo);
    }
}