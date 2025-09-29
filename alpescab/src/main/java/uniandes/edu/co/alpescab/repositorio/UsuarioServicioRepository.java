package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO_PK;

public interface UsuarioServicioRepository extends JpaRepository<USUARIO_SERVICIO, USUARIO_SERVICIO_PK> {
}
