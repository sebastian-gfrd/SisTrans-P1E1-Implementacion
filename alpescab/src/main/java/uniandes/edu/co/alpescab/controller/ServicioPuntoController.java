package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.SERVICIO_PUNTO;
import uniandes.edu.co.alpescab.repositorio.ServicioPuntoRepository;

import java.util.List;

@RestController
public class ServicioPuntoController {

    @Autowired
    private ServicioPuntoRepository servicioPuntoRepository;

    @GetMapping("/servicios-punto")
    public List<SERVICIO_PUNTO> getServiciosPunto() {
        return servicioPuntoRepository.findAll();
    }
}
