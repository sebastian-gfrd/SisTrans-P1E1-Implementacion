package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.PUNTO_UBICACION;
import uniandes.edu.co.alpescab.repositorio.PuntoUbicacionRepository;

import java.util.List;

@RestController
public class PuntoUbicacionController {

    @Autowired
    private PuntoUbicacionRepository puntoUbicacionRepository;

    @GetMapping("/puntos-ubicacion")
    public List<PUNTO_UBICACION> getPuntosUbicacion() {
        return puntoUbicacionRepository.findAll();
    }
}