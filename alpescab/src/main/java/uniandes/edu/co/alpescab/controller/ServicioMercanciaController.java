package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.SERVICIO_MERCANCIA;
import uniandes.edu.co.alpescab.repositorio.ServicioMercanciaRepository;

import java.util.List;

@RestController
public class ServicioMercanciaController {

    @Autowired
    private ServicioMercanciaRepository servicioMercanciaRepository;

    @GetMapping("/servicios-mercancia")
    public List<SERVICIO_MERCANCIA> getServiciosMercancia() {
        return servicioMercanciaRepository.findAll();
    }
}