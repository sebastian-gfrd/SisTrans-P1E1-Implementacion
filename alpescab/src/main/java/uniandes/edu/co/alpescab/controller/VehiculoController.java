package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.VEHICULO;
import uniandes.edu.co.alpescab.repositorio.VehiculoRepository;

import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/vehiculos")
    public List<VEHICULO> getVehiculos() {
        return vehiculoRepository.findAll();
    }
}
