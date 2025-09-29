package uniandes.edu.co.alpescab.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class SERVICIO_PUNTO_PK implements Serializable {
     @ManyToOne
    @JoinColumn(name="ID_SERVICIO",referencedColumnName = "ID_SERVICIO")
    private SERVICIO SERVICIO;
     @ManyToOne
    @JoinColumn(name="ID_UBICACION",referencedColumnName = "ID_PUNTO")
    private PUNTO_UBICACION ID_UBICACION ;
     public SERVICIO_PUNTO_PK(SERVICIO sERVICIO,
            PUNTO_UBICACION iD_UBICACION) {
        SERVICIO = sERVICIO;
        ID_UBICACION = iD_UBICACION;
     }
     public SERVICIO getSERVICIO() {
         return SERVICIO;
     }
     public void setSERVICIO(SERVICIO sERVICIO) {
         SERVICIO = sERVICIO;
     }
     public PUNTO_UBICACION getID_UBICACION() {
         return ID_UBICACION;
     }
     public void setID_UBICACION(PUNTO_UBICACION iD_UBICACION) {
         ID_UBICACION = iD_UBICACION;
     }
    


    
}
