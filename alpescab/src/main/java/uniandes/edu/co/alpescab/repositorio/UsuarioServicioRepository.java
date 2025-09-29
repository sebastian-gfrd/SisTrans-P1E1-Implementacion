package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO;
import uniandes.edu.co.alpescab.modelo.USUARIO_SERVICIO_PK;

public interface UsuarioServicioRepository extends JpaRepository<USUARIO_SERVICIO, USUARIO_SERVICIO_PK> {

    //RF2
    // Insertamos la persona ya que usario hereda de persona
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO PERSONA(CEDULA, NOMBRE, CONTACTO, NUMERO_CELULAR) " +
                   "VALUES(:CEDULA, :NOMBRE, :CONTACTO, :NUMERO_CELULAR)", nativeQuery = true)
    void insertarPersona(@Param("CEDULA") String cedula,
                         @Param("NOMBRE") String nombre,
                         @Param("CONTACTO") String contacto,
                         @Param("NUMERO_CELULAR") String numeroCelular);
    // Insertamos el Usuario general                     
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USUARIO(CEDULA, CORREO, ESTADO, FECHA_REGISTRO, CALIFICACION) " +
                   "VALUES(:CEDULA, :CORREO, 'ACTIVO', SYSDATE, 0)", nativeQuery = true)
    void insertarUsuario(@Param("CEDULA") String cedula,
                         @Param("CORREO") String correo);

     // Insertamos el Usario servicio                   
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USUARIO_SERVICIO(ID_USUARIO, ID_TARJETA) " +
                   "VALUES(:ID_USUARIO, :ID_TARJETA)", nativeQuery = true)
    void registrarUsuarioServicio(@Param("ID_USUARIO") Long idUsuario,
                                  @Param("ID_TARJETA") Long idTarjeta);
    
}
