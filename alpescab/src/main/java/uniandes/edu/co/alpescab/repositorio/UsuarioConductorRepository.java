package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;

public interface UsuarioConductorRepository extends JpaRepository<USUARIO_CONDUCTOR, Integer> {
}