package uniandes.edu.co.parranderos.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.Bebida;
import uniandes.edu.co.parranderos.repositorio.BebidaRepository;
import uniandes.edu.co.parranderos.repositorio.BebidaRepository.RespuestaInformacionBebidas;

@RestController
public class BebidasController {

    @Autowired
    private BebidaRepository bebidaRepository;

    @GetMapping("/bebidas")
    public ResponseEntity<Collection<Bebida>> bebidas() {
        try {
            Collection<Bebida> bebidas = bebidaRepository.darBebidas();
            return ResponseEntity.ok(bebidas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/bebidas/consulta")
    public ResponseEntity<?> bebidasConsulta(@RequestParam(required = false) String ciudad,
                                             @RequestParam(required = false) String minGrado,
                                             @RequestParam(required = false) String maxGrado) {

        try {
            Collection<RespuestaInformacionBebidas> informacion = bebidaRepository.darInformacionBebidas();
            RespuestaInformacionBebidas info = informacion.iterator().next();

            Map<String, Object> response = new HashMap<>();
            response.put("totalBebidas", info.getTOTAL_BEBIDAS());
            response.put("promedioGrado", info.getPROMEDIO_GRADO());
            response.put("mayorGrado", info.getMAYOR_GRADO());
            response.put("menorGrado", info.getMENOR_GRADO());

            Collection<Bebida> bebidas;
            if ((ciudad == null || ciudad.isEmpty()) || (minGrado == null || minGrado.isEmpty()) || (maxGrado == null || maxGrado.isEmpty())) {
                bebidas = bebidaRepository.darBebidas();
            } else {
                bebidas = bebidaRepository.darBebidasPorCiudadYGrado(ciudad, Integer.parseInt(minGrado), Integer.parseInt(maxGrado));
            }
            response.put("bebidas", bebidas);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/bebidas/new/save")
    public ResponseEntity<?> bebidaGuardar(@RequestBody Bebida bebida) {
        try {
            bebidaRepository.insertarBebida(bebida.getNombre(), bebida.getGrado_alcohol(), bebida.getTipo().getId());
            return ResponseEntity.status(HttpStatus.CREATED).body("Bebida creada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la bebida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bebidas/{id}/edit/save")
    public ResponseEntity<?> bebidaEditarGuardar(@PathVariable("id") long id, @RequestBody Bebida bebida) {
        try {
            bebidaRepository.actualizarBebida(id, bebida.getNombre(), bebida.getGrado_alcohol(), bebida.getTipo().getId());
            return ResponseEntity.ok("Bebida actualizada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar la bebida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bebidas/{id}/delete")
    public ResponseEntity<?> bebidaBorrar(@PathVariable("id") long id) {
        try {
            bebidaRepository.eliminarBebida(id);
            return ResponseEntity.ok("Bebida eliminada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bebida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}