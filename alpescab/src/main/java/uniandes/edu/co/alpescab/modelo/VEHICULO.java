package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VEHICULO")
public class VEHICULO {
    @Id
    private String PLACA;
    private String TIPO_VEHICULO;
    private String MARCA;
    private String MODELO;
    private String COLOR;
    private Integer CAPACIDAD;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO") // FK hacia USUARIO_CONDUCTOR
    private USUARIO_CONDUCTOR idUsuario;

    @ManyToOne
    @JoinColumn(name="ID_CIUDAD_EXP",referencedColumnName="ID_CIUDAD")
    private CIUDAD ID_CIUDAD;

    public VEHICULO(String pLACA, String tIPO_VEHICULO, String mARCA, String mODELO, String cOLOR, Integer cAPACIDAD,
            USUARIO_CONDUCTOR idUsuario, CIUDAD iD_CIUDAD) {
        this.PLACA = pLACA;
        this.TIPO_VEHICULO = tIPO_VEHICULO;
        this.MARCA = mARCA;
        this.MODELO = mODELO;
        this.COLOR = cOLOR;
        this.CAPACIDAD = cAPACIDAD;
        this.idUsuario = idUsuario;
        this.ID_CIUDAD = iD_CIUDAD;
    }

    public VEHICULO() {
        ;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String pLACA) {
        PLACA = pLACA;
    }

    public String getTIPO_VEHICULO() {
        return TIPO_VEHICULO;
    }

    public void setTIPO_VEHICULO(String tIPO_VEHICULO) {
        TIPO_VEHICULO = tIPO_VEHICULO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String mARCA) {
        MARCA = mARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String mODELO) {
        MODELO = mODELO;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String cOLOR) {
        COLOR = cOLOR;
    }

    public Integer getCAPACIDAD() {
        return CAPACIDAD;
    }

    public void setCAPACIDAD(Integer cAPACIDAD) {
        CAPACIDAD = cAPACIDAD;
    }

    public USUARIO_CONDUCTOR getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(USUARIO_CONDUCTOR idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CIUDAD getID_CIUDAD() {
        return ID_CIUDAD;
    }

    public void setID_CIUDAD(CIUDAD iD_CIUDAD) {
        ID_CIUDAD = iD_CIUDAD;
    }
}