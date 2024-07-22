package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.parranderos.modelo.Gustan;
import uniandes.edu.co.parranderos.modelo.GustanPK;
import uniandes.edu.co.parranderos.repositorio.GustanRepository;

@RestController
public class GustanController {

    @Autowired
    private GustanRepository gustanRepository;

    @GetMapping("/gustan")
    public ResponseEntity<Collection<Gustan>> gustan() {
        try {
            Collection<Gustan> gustan = gustanRepository.darGustan();
            return ResponseEntity.ok(gustan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/gustan/new/save")
    public ResponseEntity<?> createGustan(@RequestBody Gustan gustan) {
        try {
            GustanPK pk = gustan.getPk();

            if (pk == null || pk.getId_bebedor() == null || pk.getId_bebida() == null) {
                throw new RuntimeException("Faltan datos en la clave primaria");
            }

            Integer idBebedor = pk.getId_bebedor().getId();
            Integer idBebida = pk.getId_bebida().getId();

            gustanRepository.insertarGustan(idBebedor, idBebida);

            Gustan nuevoGustan = gustanRepository.darGustanPorId(idBebedor, idBebida);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGustan);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el registro", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}