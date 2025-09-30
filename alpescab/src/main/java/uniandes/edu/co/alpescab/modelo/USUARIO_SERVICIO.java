package uniandes.edu.co.alpescab.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO_SERVICIO")
public class USUARIO_SERVICIO {

    @Id
    private Integer ID_USUARIO; // PK compartido con USUARIO
    
    @OneToOne
    @MapsId // Esto indica que el ID viene del objeto usuario
    @JoinColumn(name = "ID_USUARIO")
    private USUARIO usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TARJETA", referencedColumnName = "ID_TARJETA")
    @JsonProperty("id_tarjeta")
    private TARJETA_CREDITO id_tarjeta;
    
    private Integer CALIFICACIONUSUARIO;

    public USUARIO_SERVICIO() {
    }
    
    public USUARIO_SERVICIO(USUARIO usuario, TARJETA_CREDITO id_tarjeta) {
        this.usuario = usuario;
        this.id_tarjeta = id_tarjeta;
        this.CALIFICACIONUSUARIO = 5;
    }

    public Integer getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(Integer id_usuario) {
        ID_USUARIO = id_usuario;
    }

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }

    public TARJETA_CREDITO getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(TARJETA_CREDITO id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public Integer getCALIFICACIONUSUARIO() {
        return CALIFICACIONUSUARIO;
    }

    public void setCALIFICACIONUSUARIO(Integer calificacionusuario) {
        CALIFICACIONUSUARIO = calificacionusuario;
    }
}
