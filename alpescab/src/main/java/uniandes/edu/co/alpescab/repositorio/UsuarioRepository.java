package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.USUARIO;

public interface UsuarioRepository extends JpaRepository<USUARIO, Integer> {
}
