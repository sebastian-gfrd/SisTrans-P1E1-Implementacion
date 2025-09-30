package uniandes.edu.co.alpescab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO;
import uniandes.edu.co.alpescab.modelo.USUARIO;
import uniandes.edu.co.alpescab.modelo.PERSONA;
import uniandes.edu.co.alpescab.modelo.TARJETA_CREDITO;
import uniandes.edu.co.alpescab.repositorio.UsuarioServicioRepository;
import uniandes.edu.co.alpescab.repositorio.UsuarioRepository;
import uniandes.edu.co.alpescab.repositorio.PersonaRepository;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios-servicio")
public class UsuarioServicioController {

    @Autowired
    private UsuarioServicioRepository usuarioServicioRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<USUARIO_SERVICIO> getUsuariosServicio() {
        return usuarioServicioRepository.findAll();
    }

    @PostMapping
    @Transactional
    public USUARIO_SERVICIO addUsuarioServicio(@RequestBody Map<String, Object> requestData) {
        try {
            // Extraer datos de persona
            String cedula = (String) requestData.get("cedula");
            String nombre = (String) requestData.get("nombre");
            String contacto = (String) requestData.get("contacto");
            String numeroCelu = (String) requestData.get("numero_celu");
            
            // Extraer datos de usuario
            String correo = (String) requestData.get("correo");
            String estado = (String) requestData.get("estado");
            
            // Extraer datos de tarjeta
            @SuppressWarnings("unchecked")
            Map<String, Object> tarjetaData = (Map<String, Object>) requestData.get("tarjeta");
            
            // Crear o buscar persona
            PERSONA persona = personaRepository.findById(cedula).orElse(null);
            if (persona == null) {
                persona = new PERSONA(cedula, nombre, contacto, numeroCelu);
                persona = personaRepository.save(persona);
            }
            
            // Crear usuario
            USUARIO usuario = new USUARIO(persona, correo, estado);
            usuario = usuarioRepository.save(usuario);
            
            // Crear tarjeta de crédito
            TARJETA_CREDITO tarjeta = new TARJETA_CREDITO();
            tarjeta.setNUMERO_TARJETA((String) tarjetaData.get("numero_tarjeta"));
            tarjeta.setNOMBRE_EN_TARJETA((String) tarjetaData.get("nombre_en_tarjeta"));
            tarjeta.setFECHA_VENCIMIENTO(LocalDate.parse((String) tarjetaData.get("fecha_vencimiento")));
            tarjeta.setCODIGO_SEGURIDAD((String) tarjetaData.get("codigo_seguridad"));
            
            // Crear usuario servicio
            USUARIO_SERVICIO usuarioServicio = new USUARIO_SERVICIO(usuario, tarjeta);
            
            return usuarioServicioRepository.save(usuarioServicio);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear usuario servicio: " + e.getMessage(), e);
        }
    }
}