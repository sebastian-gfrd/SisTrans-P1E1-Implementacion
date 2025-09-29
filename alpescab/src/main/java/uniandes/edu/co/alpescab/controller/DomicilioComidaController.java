package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.DOMICILIO_COMIDA;
import uniandes.edu.co.alpescab.repositorio.DomicilioComidaRepository;

import java.util.List;

@RestController
public class DomicilioComidaController {

    @Autowired
    private DomicilioComidaRepository domicilioComidaRepository;

    @GetMapping("/domicilios-comida")
    public List<DOMICILIO_COMIDA> getDomiciliosComida() {
        return domicilioComidaRepository.findAll();
    }
}