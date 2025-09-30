package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO_CONDUCTOR")
public class USUARIO_CONDUCTOR {

    @Id
    private Integer ID_USUARIO; // PK compartido con USUARIO
    
    @OneToOne
    @MapsId // Esto indica que el ID viene del objeto usuario
    @JoinColumn(name = "ID_USUARIO")
    private USUARIO usuario;

    private String CERTIFICADO;
    private Integer CALIFICACION;

    public USUARIO_CONDUCTOR() {
    }
    
    public USUARIO_CONDUCTOR(USUARIO usuario, String certificado) {
        this.usuario = usuario;
        this.CERTIFICADO = certificado;
        this.CALIFICACION = 5;
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

    public String getCERTIFICADO() {
        return CERTIFICADO;
    }

    public void setCERTIFICADO(String certificado) {
        CERTIFICADO = certificado;
    }

    public Integer getCALIFICACION() {
        return CALIFICACION;
    }

    public void setCALIFICACION(Integer calificacion) {
        CALIFICACION = calificacion;
    }
}
