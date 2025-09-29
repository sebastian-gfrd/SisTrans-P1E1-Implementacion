package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.DOMICILIO_COMIDA;
import uniandes.edu.co.alpescab.modelo.SERVICIO_PK;

public interface DomicilioComidaRepository extends JpaRepository<DOMICILIO_COMIDA, SERVICIO_PK> {
}
