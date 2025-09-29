package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.CIUDAD;
import uniandes.edu.co.alpescab.repositorio.CiudadRepository;

import java.util.List;

@RestController
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/ciudades")
    public List<CIUDAD> getCiudades() {
        return ciudadRepository.findAll();
    }
}