package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.TRANSPORTE_PASAJERO;
import uniandes.edu.co.alpescab.repositorio.TransportePasajeroRepository;

import java.util.List;

@RestController
public class TransportePasajeroController {

    @Autowired
    private TransportePasajeroRepository transportePasajeroRepository;

    @GetMapping("/transportes-pasajero")
    public List<TRANSPORTE_PASAJERO> getTransportesPasajero() {
        return transportePasajeroRepository.findAll();
    }
}