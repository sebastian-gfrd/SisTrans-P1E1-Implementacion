package uniandes.edu.co.alpescab.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.alpescab.modelo.DISPONIBILIDAD_CONDUCTOR;
import uniandes.edu.co.alpescab.modelo.USUARIO_CONDUCTOR;

public interface DisponibilidadConductorRepository extends JpaRepository<DISPONIBILIDAD_CONDUCTOR, Integer> {

    @Query("SELECT d FROM DISPONIBILIDAD_CONDUCTOR d WHERE d.idUsuarioConductor.ID_USUARIO = :id_usuario_conductor AND d.horario_inicio < :horario_fin AND d.horario_fin > :horario_inicio")
    List<DISPONIBILIDAD_CONDUCTOR> findOverlappingDisponibilidad(@Param("id_usuario_conductor") Integer id_usuario_conductor, @Param("horario_inicio") LocalDateTime horario_inicio, @Param("horario_fin") LocalDateTime horario_fin);

    @Query("SELECT d FROM DISPONIBILIDAD_CONDUCTOR d WHERE d.idUsuarioConductor.ID_USUARIO = :id_usuario_conductor AND d.id_disponibilidad != :id_disponibilidad AND d.horario_inicio < :horario_fin AND d.horario_fin > :horario_inicio")
    List<DISPONIBILIDAD_CONDUCTOR> findOverlappingDisponibilidadExcludingId(@Param("id_usuario_conductor") Integer id_usuario_conductor, @Param("horario_inicio") LocalDateTime horario_inicio, @Param("horario_fin") LocalDateTime horario_fin, @Param("id_disponibilidad") Integer id_disponibilidad);

    @Query(value = "SELECT * FROM DISPONIBILIDAD_CONDUCTOR WHERE tipo_servicio = :tipo_servicio AND asignado = '0' FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    DISPONIBILIDAD_CONDUCTOR findAvailableDriver(@Param("tipo_servicio") String tipo_servicio);

    DISPONIBILIDAD_CONDUCTOR findByIdUsuarioConductorAndAsignado(USUARIO_CONDUCTOR id_usuario_conductor, String asignado);
}
