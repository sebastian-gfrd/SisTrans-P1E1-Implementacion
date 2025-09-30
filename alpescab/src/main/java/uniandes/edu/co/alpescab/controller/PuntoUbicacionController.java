package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.PUNTO_UBICACION;
import uniandes.edu.co.alpescab.repositorio.PuntoUbicacionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/puntos-ubicacion")
public class PuntoUbicacionController {

    @Autowired
    private PuntoUbicacionRepository puntoUbicacionRepository;

    @GetMapping
    public List<PUNTO_UBICACION> getPuntosUbicacion() {
        return puntoUbicacionRepository.findAll();
    }

    @PostMapping
    public PUNTO_UBICACION addPuntoUbicacion(@RequestBody PUNTO_UBICACION puntoUbicacion) {
        return puntoUbicacionRepository.save(puntoUbicacion);
    }
}