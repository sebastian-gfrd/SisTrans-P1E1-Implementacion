package uniandes.edu.co.parranderos.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.parranderos.modelo.Bebedor;
import uniandes.edu.co.parranderos.repositorio.BebedorRepository;

@RestController
public class BebedoresController {

    @Autowired
    private BebedorRepository bebedorRepository;

    @GetMapping("/bebedores")
    public ResponseEntity<Collection<Bebedor>> bebedores() {
        try {
            Collection<Bebedor> bebedores = bebedorRepository.darBebedores();
            return ResponseEntity.ok(bebedores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/bebedores/consulta")
    public ResponseEntity<Map<String, Object>> bebedoresConsulta(@RequestParam(required = false) String nombre) {
        try {
            int bebedoresGustanBebidasMayorGrado = bebedorRepository.darNumeroDeBebedoresQueGustanDeBebidasConMayorGradoAlcohol();
            int bebedoresGustanBebidasMenorGrado = bebedorRepository.darNumeroDeBebedoresQueGustanDeBebidasConMenorGradoAlcohol();
            Collection<Bebedor> bebedores;
            if (nombre != null && !nombre.isEmpty()) {
                bebedores = bebedorRepository.darBebedoresPorNombre(nombre);
            } else {
                bebedores = bebedorRepository.darBebedores();
            }

            Map<String, Object> response = new HashMap<>();
            response.put("bebedoresGustanBebidasMayorGrado", bebedoresGustanBebidasMayorGrado);
            response.put("bebedoresGustanBebidasMenorGrado", bebedoresGustanBebidasMenorGrado);
            response.put("bebedores", bebedores);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/bebedores/new/save")
    public ResponseEntity<?> bebedorGuardar(@RequestBody Bebedor bebedor) {
        try {
            bebedorRepository.insertarBebedor(bebedor.getNombre(), bebedor.getCiudad(), bebedor.getPresupuesto());
            return ResponseEntity.status(HttpStatus.CREATED).body("Bebedor creado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el bebedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bebedores/{id}/edit/save")
    public ResponseEntity<?> bebedorEditarGuardar(@PathVariable("id") long id, @RequestBody Bebedor bebedor) {
        try {
            bebedorRepository.actualizarBebedor(id, bebedor.getNombre(), bebedor.getCiudad(), bebedor.getPresupuesto());
            return ResponseEntity.ok("Bebedor actualizado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el bebedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bebedores/{id}/delete")
    public ResponseEntity<?> bebedorBorrar(@PathVariable("id") long id) {
        try {
            bebedorRepository.eliminarBebedor(id);
            return ResponseEntity.ok("Bebedor eliminado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el bebedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
