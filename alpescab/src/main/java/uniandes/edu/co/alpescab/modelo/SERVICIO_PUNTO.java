package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="SERVICIO_PUNTO")
public class SERVICIO_PUNTO {
    @EmbeddedId
    private SERVICIO_PUNTO_PK PK_Punto;
    private Integer ORDEN;
    public SERVICIO_PUNTO(SERVICIO servicio,PUNTO_UBICACION punto,Integer oRDEN) {
        PK_Punto = new SERVICIO_PUNTO_PK(servicio, punto);
        ORDEN = oRDEN;
    }
    public SERVICIO_PUNTO(){;}
    public SERVICIO_PUNTO_PK getPK_Punto() {
        return PK_Punto;
    }
    public void setPK_Punto(SERVICIO_PUNTO_PK pK_Punto) {
        PK_Punto = pK_Punto;
    }
    public Integer getORDEN() {
        return ORDEN;
    }
    public void setORDEN(Integer oRDEN) {
        ORDEN = oRDEN;
    }
    
}
    

