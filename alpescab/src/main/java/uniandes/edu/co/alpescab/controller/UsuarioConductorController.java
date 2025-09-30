package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;
import uniandes.edu.co.alpescab.repositorio.UsuarioConductorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-conductor")
public class UsuarioConductorController {

    @Autowired
    private UsuarioConductorRepository usuarioConductorRepository;

    @GetMapping
    public List<USUARIO_CONDUCTOR> getUsuariosConductor() {
        return usuarioConductorRepository.findAll();
    }

    @PostMapping
    public USUARIO_CONDUCTOR addUsuarioConductor(@RequestBody USUARIO_CONDUCTOR usuarioConductor) {
        return usuarioConductorRepository.save(usuarioConductor);
    }
}