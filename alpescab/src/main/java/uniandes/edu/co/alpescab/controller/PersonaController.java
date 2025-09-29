package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.PERSONA;
import uniandes.edu.co.alpescab.repositorio.PersonaRepository;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<PERSONA> getPersonas() {
        return personaRepository.findAll();
    }
}
