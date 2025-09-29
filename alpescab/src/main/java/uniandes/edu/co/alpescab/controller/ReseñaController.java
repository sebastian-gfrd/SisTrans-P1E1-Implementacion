package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.RESEÑA;
import uniandes.edu.co.alpescab.repositorio.ReseñaRepository;

import java.util.List;

@RestController
public class ReseñaController {

    @Autowired
    private ReseñaRepository reseñaRepository;

    @GetMapping("/reseñas")
    public List<RESEÑA> getReseñas() {
        return reseñaRepository.findAll();
    }
}
