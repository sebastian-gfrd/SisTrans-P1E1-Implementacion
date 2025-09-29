package uniandes.edu.co.alpescab.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class SERVICIO_PK  implements Serializable{
    @OneToOne
    @JoinColumn(name="ID_SERVICIO",referencedColumnName = "ID_SERVICIO")
    private SERVICIO SERVICIO;

    public SERVICIO_PK(SERVICIO sERVICIO) {
        SERVICIO = sERVICIO;
    }

    public SERVICIO getSERVICIO() {
        return SERVICIO;
    }

    public void setSERVICIO(SERVICIO sERVICIO) {
        SERVICIO = sERVICIO;
    }
    
}
