package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="DOMICILIO_COMIDA")
public class DOMICILIO_COMIDA extends SERVICIO {

    private String NUMERO_ORDEN;
    private String DETALLE_ORDEN;
    private String RESTAURANTE;

    public DOMICILIO_COMIDA(Integer nivel, String mODALIDAD, Integer dISTANCIA_KM, Integer cOSTO, Float comision, LocalDateTime hORA_INICIO,
            LocalDateTime hORA_FIN, VEHICULO vEHICULO, USUARIO_SERVICIO cliente, USUARIO_CONDUCTOR conductor, String numero_orden, String detalle_orden, String restaurante) {
        super(nivel, mODALIDAD, dISTANCIA_KM, cOSTO, comision, hORA_INICIO, hORA_FIN, vEHICULO, cliente, conductor);
        this.NUMERO_ORDEN = numero_orden;
        this.DETALLE_ORDEN = detalle_orden;
        this.RESTAURANTE = restaurante;
    }

    public DOMICILIO_COMIDA() {
        super();
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