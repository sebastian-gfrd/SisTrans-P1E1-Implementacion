package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.PUNTO_UBICACION;

public interface PuntoUbicacionRepository extends JpaRepository<PUNTO_UBICACION, Integer> {
}
