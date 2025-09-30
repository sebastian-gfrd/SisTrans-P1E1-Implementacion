package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;
import uniandes.edu.co.alpescab.modelo.USUARIO;
import uniandes.edu.co.alpescab.modelo.PERSONA;
import uniandes.edu.co.alpescab.repositorio.UsuarioConductorRepository;
import uniandes.edu.co.alpescab.repositorio.UsuarioRepository;
import uniandes.edu.co.alpescab.repositorio.PersonaRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios-conductor")
public class UsuarioConductorController {

    @Autowired
    private UsuarioConductorRepository usuarioConductorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<USUARIO_CONDUCTOR> getUsuariosConductor() {
        return usuarioConductorRepository.findAll();
    }

    @PostMapping
    @Transactional
    public USUARIO_CONDUCTOR addUsuarioConductor(@RequestBody Map<String, Object> userData) {
        // Extract data from request
        String cedula = (String) userData.get("cedula");
        String certificado = (String) userData.get("certificado");
        
        // Check if PERSONA exists, if not create it
        PERSONA persona = personaRepository.findById(cedula).orElse(null);
        if (persona == null) {
            // Create new PERSONA
            String nombre = (String) userData.get("nombre");
            String contacto = (String) userData.get("contacto");
            String numeroCelular = (String) userData.get("numero_celular");
            
            persona = new PERSONA();
            persona.setCEDULA(cedula);
            persona.setNOMBRE(nombre);
            persona.setCONTACTO(contacto);
            persona.setNUMERO_CELULAR(numeroCelular);
            persona = personaRepository.save(persona);
        }

        // Create USUARIO
        String correo = (String) userData.get("correo");
        String estado = (String) userData.get("estado");
        
        USUARIO usuario = new USUARIO(persona, correo, estado);
        usuario = usuarioRepository.save(usuario);

        // Create USUARIO_CONDUCTOR
        USUARIO_CONDUCTOR usuarioConductor = new USUARIO_CONDUCTOR(usuario, certificado);
        return usuarioConductorRepository.save(usuarioConductor);
    }
}