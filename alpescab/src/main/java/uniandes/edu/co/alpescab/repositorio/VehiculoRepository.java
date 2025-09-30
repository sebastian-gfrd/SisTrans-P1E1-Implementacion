package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;
import uniandes.edu.co.alpescab.modelo.VEHICULO;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<VEHICULO, String> {
    List<VEHICULO> findByIdUsuario(USUARIO_CONDUCTOR idUsuario);
}
