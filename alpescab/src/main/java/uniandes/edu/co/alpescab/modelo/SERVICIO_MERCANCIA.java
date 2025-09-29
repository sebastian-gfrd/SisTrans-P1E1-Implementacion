package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="SERVICIO_MERCANCIA")
public class SERVICIO_MERCANCIA {
   @EmbeddedId
   private SERVICIO_PK   ID_SERVICIO ; 
   private String  DESCRIPCION;
   private Integer PESO_APROXIMADO;
   public SERVICIO_MERCANCIA(SERVICIO iD_SERVICIO, String dESCRIPCION, Integer pESO_APROXIMADO) {
    ID_SERVICIO = new SERVICIO_PK(iD_SERVICIO);
    DESCRIPCION = dESCRIPCION;
    PESO_APROXIMADO = pESO_APROXIMADO;
   }
   public SERVICIO_PK getID_SERVICIO() {
    return ID_SERVICIO;
   }
   public void setID_SERVICIO(SERVICIO_PK iD_SERVICIO) {
    ID_SERVICIO = iD_SERVICIO;
   }
   public String getDESCRIPCION() {
    return DESCRIPCION;
   }
   public void setDESCRIPCION(String dESCRIPCION) {
    DESCRIPCION = dESCRIPCION;
   }
   public Integer getPESO_APROXIMADO() {
    return PESO_APROXIMADO;
   }
   public void setPESO_APROXIMADO(Integer pESO_APROXIMADO) {
    PESO_APROXIMADO = pESO_APROXIMADO;
   }
   
    
}
