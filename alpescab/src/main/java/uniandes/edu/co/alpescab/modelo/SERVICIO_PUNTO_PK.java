package uniandes.edu.co.alpescab.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SERVICIO_PUNTO_PK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    private SERVICIO SERVICIO;

    @ManyToOne
    @JoinColumn(name = "ID_UBICACION", referencedColumnName = "ID_PUNTO")
    private PUNTO_UBICACION ID_UBICACION;

    public SERVICIO_PUNTO_PK(SERVICIO sERVICIO, PUNTO_UBICACION iD_UBICACION) {
        this.SERVICIO = sERVICIO;
        this.ID_UBICACION = iD_UBICACION;
    }

    public SERVICIO_PUNTO_PK() {
    }

    public SERVICIO getSERVICIO() {
        return SERVICIO;
    }

    public void setSERVICIO(SERVICIO sERVICIO) {
        this.SERVICIO = sERVICIO;
    }

    public PUNTO_UBICACION getID_UBICACION() {
        return ID_UBICACION;
    }

    public void setID_UBICACION(PUNTO_UBICACION iD_UBICACION) {
        this.ID_UBICACION = iD_UBICACION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SERVICIO_PUNTO_PK that = (SERVICIO_PUNTO_PK) o;
        return Objects.equals(SERVICIO, that.SERVICIO) && Objects.equals(ID_UBICACION, that.ID_UBICACION);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SERVICIO, ID_UBICACION);
    }
}
