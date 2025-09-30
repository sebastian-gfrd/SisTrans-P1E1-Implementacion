package uniandes.edu.co.alpescab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.alpescab.modelo.DISPONIBILIDAD_CONDUCTOR;
import uniandes.edu.co.alpescab.modelo.DisponibilidadConductorDTO;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;
import uniandes.edu.co.alpescab.repositorio.DisponibilidadConductorRepository;
import uniandes.edu.co.alpescab.repositorio.UsuarioConductorRepository;

@RestController
@RequestMapping("/api/disponibilidades-conductor")
public class DisponibilidadConductorController {

    @Autowired
    private DisponibilidadConductorRepository disponibilidadConductorRepository;

    @Autowired
    private UsuarioConductorRepository usuarioConductorRepository;

    @GetMapping
    public List<DISPONIBILIDAD_CONDUCTOR> getDisponibilidadesConductor() {
        return disponibilidadConductorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<DISPONIBILIDAD_CONDUCTOR> addDisponibilidadConductor(@RequestBody DisponibilidadConductorDTO disponibilidadDTO) {
        List<DISPONIBILIDAD_CONDUCTOR> overlapping = disponibilidadConductorRepository.findOverlappingDisponibilidad(
                disponibilidadDTO.getIdUsuarioConductor(),
                disponibilidadDTO.getHorario_inicio(),
                disponibilidadDTO.getHorario_fin());

        if (!overlapping.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        USUARIO_CONDUCTOR conductor = usuarioConductorRepository.findById(disponibilidadDTO.getIdUsuarioConductor()).get();

        DISPONIBILIDAD_CONDUCTOR newDisponibilidad = new DISPONIBILIDAD_CONDUCTOR();
        newDisponibilidad.setIdUsuarioConductor(conductor);
        newDisponibilidad.setDia(disponibilidadDTO.getDia());
        newDisponibilidad.setHorario_inicio(disponibilidadDTO.getHorario_inicio());
        newDisponibilidad.setHorario_fin(disponibilidadDTO.getHorario_fin());
        newDisponibilidad.setTipo_servicio(disponibilidadDTO.getTipo_servicio());
        newDisponibilidad.setAsignado("0");

        DISPONIBILIDAD_CONDUCTOR savedDisponibilidad = disponibilidadConductorRepository.save(newDisponibilidad);
        return new ResponseEntity<>(savedDisponibilidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DISPONIBILIDAD_CONDUCTOR> updateDisponibilidadConductor(@PathVariable Integer id, @RequestBody DisponibilidadConductorDTO disponibilidadDTO) {
        List<DISPONIBILIDAD_CONDUCTOR> overlapping = disponibilidadConductorRepository.findOverlappingDisponibilidadExcludingId(
                disponibilidadDTO.getIdUsuarioConductor(),
                disponibilidadDTO.getHorario_inicio(),
                disponibilidadDTO.getHorario_fin(),
                id);

        if (!overlapping.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        USUARIO_CONDUCTOR conductor = usuarioConductorRepository.findById(disponibilidadDTO.getIdUsuarioConductor()).get();

        DISPONIBILIDAD_CONDUCTOR existingDisponibilidad = disponibilidadConductorRepository.findById(id).get();
        existingDisponibilidad.setIdUsuarioConductor(conductor);
        existingDisponibilidad.setDia(disponibilidadDTO.getDia());
        existingDisponibilidad.setHorario_inicio(disponibilidadDTO.getHorario_inicio());
        existingDisponibilidad.setHorario_fin(disponibilidadDTO.getHorario_fin());
        existingDisponibilidad.setTipo_servicio(disponibilidadDTO.getTipo_servicio());

        DISPONIBILIDAD_CONDUCTOR savedDisponibilidad = disponibilidadConductorRepository.save(existingDisponibilidad);
        return new ResponseEntity<>(savedDisponibilidad, HttpStatus.OK);
    }
}