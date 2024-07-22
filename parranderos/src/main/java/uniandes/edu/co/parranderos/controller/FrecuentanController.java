package uniandes.edu.co.parranderos.controller;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uniandes.edu.co.parranderos.modelo.Frecuentan;
import uniandes.edu.co.parranderos.modelo.FrecuentanPK;
import uniandes.edu.co.parranderos.repositorio.FrecuentanRepository;

@RestController
public class FrecuentanController {

    @Autowired
    private FrecuentanRepository frecuentanRepository;

    @GetMapping("/frecuentan")
    public ResponseEntity<Collection<Frecuentan>> frecuentan() {
        try {
            Collection<Frecuentan> frecuentan = frecuentanRepository.darFrecuentan();
            return ResponseEntity.ok(frecuentan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/frecuentan/new/save")
    public ResponseEntity<?> createFrecuentan(@RequestBody Frecuentan frecuentan) {
        try {
            FrecuentanPK pk = frecuentan.getPk();
            Integer idBebedor = pk.getId_bebedor().getId();
            Integer idBar = pk.getId_bar().getId();
            Date fechaVisita = pk.getFecha_visita();
            String horario = pk.getHorario();

            frecuentanRepository.insertarFrecuentan(idBebedor, idBar, fechaVisita, horario);
            Frecuentan nuevoFrecuentan = frecuentanRepository.darFrecuentanPorId(idBebedor, idBar, fechaVisita, horario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFrecuentan);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el registro", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}