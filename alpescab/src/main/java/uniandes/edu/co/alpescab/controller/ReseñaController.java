package uniandes.edu.co.alpescab.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.alpescab.modelo.RESEÑA;
import uniandes.edu.co.alpescab.modelo.ReseñaDTO;
import uniandes.edu.co.alpescab.modelo.SERVICIO;
import uniandes.edu.co.alpescab.modelo.USUARIO;
import uniandes.edu.co.alpescab.repositorio.ReseñaRepository;
import uniandes.edu.co.alpescab.repositorio.ServicioRepository;
import uniandes.edu.co.alpescab.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/api/reseñas")
public class ReseñaController {

    @Autowired
    private ReseñaRepository reseñaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public RESEÑA addReseña(@RequestBody ReseñaDTO reseñaDTO) {
        try {
            USUARIO autor = usuarioRepository.findById(reseñaDTO.getId_usuario_autor()).get();
            USUARIO destino = usuarioRepository.findById(reseñaDTO.getId_usuario_destino()).get();

            // Use findById to get the SERVICIO entity
            SERVICIO servicio = servicioRepository.findById(reseñaDTO.getId_servicio())
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + reseñaDTO.getId_servicio()));

            RESEÑA nuevaReseña = new RESEÑA(LocalDate.now(), reseñaDTO.getComentario(), reseñaDTO.getCalificacion(), autor, destino, servicio);
            return reseñaRepository.save(nuevaReseña);
        } catch (Exception e) {
            throw new RuntimeException("Error creating reseña: " + e.getMessage(), e);
        }
    }
}
