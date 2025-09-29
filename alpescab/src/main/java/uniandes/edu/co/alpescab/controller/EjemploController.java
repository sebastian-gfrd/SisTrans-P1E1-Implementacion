package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.Ejemplo;
import uniandes.edu.co.alpescab.repositorio.EjemploRepository;

import java.util.List;

@RestController
public class EjemploController {

    @Autowired
    private EjemploRepository ejemploRepository;

    @GetMapping("/ejemplos")
    public List<Ejemplo> getEjemplos() {
        return ejemploRepository.findAll();
    }
}
