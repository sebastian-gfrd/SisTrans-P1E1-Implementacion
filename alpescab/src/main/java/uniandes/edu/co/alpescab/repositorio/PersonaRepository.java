package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.PERSONA;

public interface PersonaRepository extends JpaRepository<PERSONA, Integer> {
}
