package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.CIUDAD;
import uniandes.edu.co.alpescab.repositorio.CiudadRepository;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping
    public List<CIUDAD> getCiudades() {
        return ciudadRepository.findAll();
    }

    @PostMapping
    public CIUDAD addCiudad(@RequestBody CIUDAD ciudad) {
        return ciudadRepository.save(ciudad);
    }
}