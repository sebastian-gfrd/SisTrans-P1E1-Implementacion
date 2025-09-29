package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO_SERVICIO")
public  class USUARIO_SERVICIO{
    @EmbeddedId
    private USUARIO_SERVICIO_PK Id_usario;
    
    @OneToOne
    @JoinColumn(name = "ID_TARJETA ", referencedColumnName = "ID_TARJETA ") // FK hacia Tarjeta
    private TARJETA_CREDITO id_tarjeta;

    public USUARIO_SERVICIO(USUARIO id_usuario, TARJETA_CREDITO id_tarjeta) {
        Id_usario = new USUARIO_SERVICIO_PK(id_usuario);
        this.id_tarjeta = id_tarjeta;
    }
    public USUARIO_SERVICIO(){;}
    public USUARIO_SERVICIO_PK getId_usario() {
        return Id_usario;
    }
    public void setId_usario(USUARIO_SERVICIO_PK id_usario) {
        Id_usario = id_usario;
    }
    public TARJETA_CREDITO getId_tarjeta() {
        return id_tarjeta;
    }
    public void setId_tarjeta(TARJETA_CREDITO id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }
    
}
