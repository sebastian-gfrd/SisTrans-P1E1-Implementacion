package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO_SERVICIO")
public class USUARIO_SERVICIO extends USUARIO {

    @OneToOne
    @JoinColumn(name = "ID_TARJETA", referencedColumnName = "ID_TARJETA") // FK hacia Tarjeta
    private TARJETA_CREDITO id_tarjeta;

    public USUARIO_SERVICIO(String cedula, String nombre, String contacto, String numero_celu, String correo, String estado, TARJETA_CREDITO id_tarjeta) {
        super(cedula, nombre, contacto, numero_celu, correo, estado);
        this.id_tarjeta = id_tarjeta;
    }

    public USUARIO_SERVICIO() {
        super();
    }

    public TARJETA_CREDITO getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(TARJETA_CREDITO id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }
}
