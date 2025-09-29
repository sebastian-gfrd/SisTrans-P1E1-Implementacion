package uniandes.edu.co.alpescab.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.alpescab.modelo.CIUDAD;


public interface CiudadRepository extends JpaRepository<CIUDAD,Integer> {

    //RF1

   @Modifying
   @Transactional
   @Query(value = "INSERT INTO CIUDAD(NOMBRE, DEPARTAMENTO) VALUES(SaokiBase_sequence.nextval,:NOMBRE, :DEPARTAMENTO)", nativeQuery = true)
    void insertarCIUDAD(@Param("NOMBRE") String nOMBRE, @Param("DEPARTAMENTO")String dEPARTAMENTO);
}
