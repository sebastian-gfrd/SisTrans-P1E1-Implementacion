package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.TARJETA_CREDITO;
import uniandes.edu.co.alpescab.repositorio.TarjetaCreditoRepository;

import java.util.List;

@RestController
public class TarjetaCreditoController {

    @Autowired
    private TarjetaCreditoRepository tarjetaCreditoRepository;

    @GetMapping("/tarjetas-credito")
    public List<TARJETA_CREDITO> getTarjetasCredito() {
        return tarjetaCreditoRepository.findAll();
    }
}
