package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uniandes.edu.co.parranderos.modelo.Bar;
import uniandes.edu.co.parranderos.repositorio.BarRepository;





@RestController
public class BaresController {

    @Autowired
    private BarRepository barRepository;

    @GetMapping("/bares")
    public Collection<Bar> bares() {
        return barRepository.darBares();
    }

    @PostMapping("/bares/new/save")
    public ResponseEntity<String> barGuardar(@RequestBody Bar bar) {
        try {
            barRepository.insertarBar(bar.getNombre(), bar.getCiudad(), bar.getPresupuesto(), bar.getCant_sedes());
            return new ResponseEntity<>("Bar creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el bar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bares/{id}/edit/save")
    public ResponseEntity<String> barEditarGuardar(@PathVariable("id") long id, @RequestBody Bar bar) {
        try {
            barRepository.actualizarBar(id, bar.getNombre(), bar.getCiudad(), bar.getPresupuesto(), bar.getCant_sedes());
            return new ResponseEntity<>("Bar actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el bar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bares/{id}/delete")
    public ResponseEntity<String> barEliminar(@PathVariable("id") long id) {
        try {
            barRepository.eliminarBar(id);
            return new ResponseEntity<>("Bar eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el bar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}