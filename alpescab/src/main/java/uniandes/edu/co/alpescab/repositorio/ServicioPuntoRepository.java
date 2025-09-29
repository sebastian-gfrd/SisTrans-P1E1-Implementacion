package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.SERVICIO_PUNTO;
import uniandes.edu.co.alpescab.modelo.SERVICIO_PUNTO_PK;

public interface ServicioPuntoRepository extends JpaRepository<SERVICIO_PUNTO, SERVICIO_PUNTO_PK> {
}
