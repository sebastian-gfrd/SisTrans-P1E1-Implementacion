package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.alpescab.modelo.Ejemplo;

public interface EjemploRepository extends JpaRepository<Ejemplo, Integer> {
}
