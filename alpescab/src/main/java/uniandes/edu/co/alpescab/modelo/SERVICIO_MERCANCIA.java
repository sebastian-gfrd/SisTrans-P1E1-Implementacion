package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="SERVICIO_MERCANCIA")
public class SERVICIO_MERCANCIA extends SERVICIO {

    private String DESCRIPCION;
    private Integer PESO_APROXIMADO;

    public SERVICIO_MERCANCIA(String mODALIDAD, Integer dISTANCIA_KM, Integer cOSTO, Float comision, LocalDateTime hORA_INICIO,
            LocalDateTime hORA_FIN, VEHICULO vEHICULO, USUARIO_SERVICIO cliente, USUARIO_CONDUCTOR conductor, String descripcion, Integer peso_aproximado) {
        super(mODALIDAD, dISTANCIA_KM, cOSTO, comision, hORA_INICIO, hORA_FIN, vEHICULO, cliente, conductor);
        this.DESCRIPCION = descripcion;
        this.PESO_APROXIMADO = peso_aproximado;
    }

    public SERVICIO_MERCANCIA() {
        super();
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
