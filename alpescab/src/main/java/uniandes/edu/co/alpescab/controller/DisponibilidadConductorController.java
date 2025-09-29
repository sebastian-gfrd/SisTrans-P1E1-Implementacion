package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.DISPONIBILIDAD_CONDUCTOR;
import uniandes.edu.co.alpescab.repositorio.DisponibilidadConductorRepository;

import java.util.List;

@RestController
public class DisponibilidadConductorController {

    @Autowired
    private DisponibilidadConductorRepository disponibilidadConductorRepository;

    @GetMapping("/disponibilidades-conductor")
    public List<DISPONIBILIDAD_CONDUCTOR> getDisponibilidadesConductor() {
        return disponibilidadConductorRepository.findAll();
    }
}
