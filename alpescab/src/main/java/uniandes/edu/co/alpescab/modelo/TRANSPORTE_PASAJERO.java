package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TRANSPORTE_PASAJERO")
public class TRANSPORTE_PASAJERO {
    @EmbeddedId
    private SERVICIO_PK   ID_SERVICIO;
    private Integer PASAJEROS;
    public TRANSPORTE_PASAJERO(SERVICIO iD_SERVICIO, Integer pASAJEROS) {
        ID_SERVICIO = new SERVICIO_PK(iD_SERVICIO);
        PASAJEROS = pASAJEROS;
    }
    public TRANSPORTE_PASAJERO(){;}
    public SERVICIO_PK getID_SERVICIO() {
        return ID_SERVICIO;
    }
    public void setID_SERVICIO(SERVICIO_PK iD_SERVICIO) {
        ID_SERVICIO = iD_SERVICIO;
    }
    public Integer getPASAJEROS() {
        return PASAJEROS;
    }
    public void setPASAJEROS(Integer pASAJEROS) {
        PASAJEROS = pASAJEROS;
    }
    


    
}

