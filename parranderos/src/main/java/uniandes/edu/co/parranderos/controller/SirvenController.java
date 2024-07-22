package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.parranderos.modelo.Bar;
import uniandes.edu.co.parranderos.modelo.Bebida;
import uniandes.edu.co.parranderos.modelo.Sirven;
import uniandes.edu.co.parranderos.modelo.SirvenPK;
import uniandes.edu.co.parranderos.repositorio.SirvenRepository;

@RestController
public class SirvenController {

    @Autowired
    private SirvenRepository sirvenRepository;

    @GetMapping("/sirven")
    public ResponseEntity<Collection<Sirven>> sirven() {
        try {
            Collection<Sirven> sirven = sirvenRepository.darSirven();
            return ResponseEntity.ok(sirven);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/sirven/new/save")
    public ResponseEntity<?> createSirven(@RequestBody Sirven sirven) {
        try {
            SirvenPK pk = sirven.getPk();

            if (pk == null || pk.getId_bar() == null || pk.getId_bebida() == null) {
                throw new RuntimeException("Faltan datos en la clave primaria");
            }

            Bar bar = pk.getId_bar();
            Bebida bebida = pk.getId_bebida();
            String horario = pk.getHorario();

            Integer idBar = bar.getId();
            Integer idBebida = bebida.getId();

            sirvenRepository.insertarSirven(idBar, idBebida, horario);

            Sirven nuevoSirven = sirvenRepository.darSirvenPorId(idBar, idBebida, horario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSirven);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el registro", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}