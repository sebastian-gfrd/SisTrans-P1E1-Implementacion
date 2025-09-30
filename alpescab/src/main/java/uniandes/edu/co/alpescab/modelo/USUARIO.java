package uniandes.edu.co.alpescab.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="USUARIO")
public class USUARIO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    private Integer ID_USUARIO;

    @ManyToOne
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
    private PERSONA persona;

    @Column(nullable = false)
    private String CORREO;

    @Column(name = "FECHA_REGISTRO", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date FECHA_REGISTRO;

    private String ESTADO;

    public USUARIO(PERSONA persona, String correo, String estado) {
        this.persona = persona;
        this.CORREO = correo;
        this.ESTADO = estado;
    }

    public USUARIO() {
    }

    public Integer getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(Integer id_usuario) {
        ID_USUARIO = id_usuario;
    }

    public PERSONA getPersona() {
        return persona;
    }

    public void setPersona(PERSONA persona) {
        this.persona = persona;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String correo) {
        CORREO = correo;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date fECHA_REGISTRO) {
        FECHA_REGISTRO = fECHA_REGISTRO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String eSTADO) {
        ESTADO = eSTADO;
    }
}
