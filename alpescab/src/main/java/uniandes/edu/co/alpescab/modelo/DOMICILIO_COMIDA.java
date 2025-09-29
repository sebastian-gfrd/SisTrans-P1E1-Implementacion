package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="DOMICILIO_COMIDA ")
public class DOMICILIO_COMIDA {
    @EmbeddedId
    private SERVICIO_PK   ID_SERVICIO;
    private String NUMERO_ORDEN;
    private String  DETALLE_ORDEN;
    private String RESTAURANTE;
    public DOMICILIO_COMIDA(SERVICIO iD_SERVICIO, String nUMERO_ORDEN, String dETALLE_ORDEN, String rESTAURANTE) {
        ID_SERVICIO = new SERVICIO_PK(iD_SERVICIO);
        NUMERO_ORDEN = nUMERO_ORDEN;
        DETALLE_ORDEN = dETALLE_ORDEN;
        RESTAURANTE = rESTAURANTE;
    }
    public DOMICILIO_COMIDA(){;}
    public SERVICIO_PK getID_SERVICIO() {
        return ID_SERVICIO;
    }
    public void setID_SERVICIO(SERVICIO_PK iD_SERVICIO) {
        ID_SERVICIO = iD_SERVICIO;
    }
    public String getNUMERO_ORDEN() {
        return NUMERO_ORDEN;
    }
    public void setNUMERO_ORDEN(String nUMERO_ORDEN) {
        NUMERO_ORDEN = nUMERO_ORDEN;
    }
    public String getDETALLE_ORDEN() {
        return DETALLE_ORDEN;
    }
    public void setDETALLE_ORDEN(String dETALLE_ORDEN) {
        DETALLE_ORDEN = dETALLE_ORDEN;
    }
    public String getRESTAURANTE() {
        return RESTAURANTE;
    }
    public void setRESTAURANTE(String rESTAURANTE) {
        RESTAURANTE = rESTAURANTE;
    }
    

    


    
}
  