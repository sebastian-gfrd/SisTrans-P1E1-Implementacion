package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.VEHICULO;
import uniandes.edu.co.alpescab.repositorio.VehiculoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public List<VEHICULO> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    @PostMapping
    public VEHICULO addVehiculo(@RequestBody VEHICULO vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}