package uniandes.edu.co.alpescab.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public abstract class USUARIO extends PERSONA {

    private String CORREO;

    @Column(name = "FECHA_REGISTRO", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date FECHA_REGISTRO;

    private String ESTADO;

    private Integer CALIFICACION;

    public USUARIO(String cedula, String nombre, String contacto, String numero_celu, String correo, String estado) {
        super(cedula, nombre, contacto, numero_celu);
        this.CORREO = correo;
        this.ESTADO = estado;
        this.CALIFICACION = 5;
    }

    public USUARIO() {
        super();
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String cORREO) {
        CORREO = cORREO;
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

    public Integer getCALIFICACION() {
        return CALIFICACION;
    }

    public void setCALIFICACION(Integer cALIFICACION) {
        CALIFICACION = cALIFICACION;
    }
}
