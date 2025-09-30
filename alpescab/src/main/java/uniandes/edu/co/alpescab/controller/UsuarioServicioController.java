package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO;
import uniandes.edu.co.alpescab.repositorio.UsuarioServicioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-servicio")
public class UsuarioServicioController {

    @Autowired
    private UsuarioServicioRepository usuarioServicioRepository;

    @GetMapping
    public List<USUARIO_SERVICIO> getUsuariosServicio() {
        return usuarioServicioRepository.findAll();
    }

    @PostMapping
    public USUARIO_SERVICIO addUsuarioServicio(@RequestBody USUARIO_SERVICIO usuarioServicio) {
        return usuarioServicioRepository.save(usuarioServicio);
    }
}