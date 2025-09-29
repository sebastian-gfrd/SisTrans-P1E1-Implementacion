package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.TRANSPORTE_PASAJERO;
import uniandes.edu.co.alpescab.modelo.SERVICIO_PK;

public interface TransportePasajeroRepository extends JpaRepository<TRANSPORTE_PASAJERO, SERVICIO_PK> {
}
