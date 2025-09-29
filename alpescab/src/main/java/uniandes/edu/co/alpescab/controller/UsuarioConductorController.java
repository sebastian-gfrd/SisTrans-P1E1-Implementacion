package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;
import uniandes.edu.co.alpescab.repositorio.UsuarioConductorRepository;

import java.util.List;

@RestController
public class UsuarioConductorController {

    @Autowired
    private UsuarioConductorRepository usuarioConductorRepository;

    @GetMapping("/usuarios-conductor")
    public List<USUARIO_CONDUCTOR> getUsuariosConductor() {
        return usuarioConductorRepository.findAll();
    }
}