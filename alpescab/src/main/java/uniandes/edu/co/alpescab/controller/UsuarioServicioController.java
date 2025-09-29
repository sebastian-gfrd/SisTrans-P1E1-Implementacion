package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO;
import uniandes.edu.co.alpescab.repositorio.UsuarioServicioRepository;

import java.util.List;

@RestController
public class UsuarioServicioController {

    @Autowired
    private UsuarioServicioRepository usuarioServicioRepository;

    @GetMapping("/usuarios-servicio")
    public List<USUARIO_SERVICIO> getUsuariosServicio() {
        return usuarioServicioRepository.findAll();
    }
}