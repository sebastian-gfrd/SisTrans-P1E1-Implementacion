package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TRANSPORTE_PASAJERO")
public class TRANSPORTE_PASAJERO extends SERVICIO {

    private Integer PASAJEROS;

    public TRANSPORTE_PASAJERO(Integer nivel, String mODALIDAD, Integer dISTANCIA_KM, Integer cOSTO, Float comision, LocalDateTime hORA_INICIO,
            LocalDateTime hORA_FIN, VEHICULO vEHICULO, USUARIO_SERVICIO cliente, USUARIO_CONDUCTOR conductor, Integer pasajeros) {
        super(nivel, mODALIDAD, dISTANCIA_KM, cOSTO, comision, hORA_INICIO, hORA_FIN, vEHICULO, cliente, conductor);
        this.PASAJEROS = pasajeros;
    }

    public TRANSPORTE_PASAJERO() {
        super();
    }

    public Integer getPASAJEROS() {
        return PASAJEROS;
    }

    public void setPASAJEROS(Integer pASAJEROS) {
        PASAJEROS = pASAJEROS;
    }
}
