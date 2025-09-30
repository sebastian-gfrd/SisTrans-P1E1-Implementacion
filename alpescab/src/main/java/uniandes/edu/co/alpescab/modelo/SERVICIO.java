package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SERVICIO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID_SERVICIO;
    private Integer NIVEL;
    private String MODALIDAD;
    private Integer DISTANCIA_KM;
    private Integer COSTO;
    private Float COMISION;
    private LocalDateTime HORA_INICIO;
    private LocalDateTime HORA_FIN;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "PLACA") // FK hacia VEHICULO
    private VEHICULO VEHICULO;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID_PERSONA") // FK hacia USUARIO
    private USUARIO_SERVICIO cliente;

    @ManyToOne
    @JoinColumn(name = "CONDUCTOR_ID", referencedColumnName = "ID_PERSONA") // FK hacia CONDUCTOR
    private USUARIO_CONDUCTOR conductor;

    public SERVICIO(Integer nivel, String mODALIDAD, Integer dISTANCIA_KM, Integer cOSTO, Float comision, LocalDateTime hORA_INICIO,
            LocalDateTime hORA_FIN, VEHICULO vEHICULO, USUARIO_SERVICIO cliente, USUARIO_CONDUCTOR conductor) {
        this.NIVEL = nivel;
        this.MODALIDAD = mODALIDAD;
        this.DISTANCIA_KM = dISTANCIA_KM;
        this.COSTO = cOSTO;
        this.COMISION = comision;
        this.HORA_INICIO = hORA_INICIO;
        this.HORA_FIN = hORA_FIN;
        this.VEHICULO = vEHICULO;
        this.cliente = cliente;
        this.conductor = conductor;
    }

    public SERVICIO() {
        ;
    }

    public Integer getID_SERVICIO() {
        return ID_SERVICIO;
    }

    public void setID_SERVICIO(Integer iD_SERVICIO) {
        ID_SERVICIO = iD_SERVICIO;
    }

    public Integer getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(Integer nivel) {
        NIVEL = nivel;
    }

    public String getMODALIDAD() {
        return MODALIDAD;
    }

    public void setMODALIDAD(String mODALIDAD) {
        MODALIDAD = mODALIDAD;
    }

    public Integer getDISTANCIA_KM() {
        return DISTANCIA_KM;
    }

    public void setDISTANCIA_KM(Integer dISTANCIA_KM) {
        DISTANCIA_KM = dISTANCIA_KM;
    }

    public Integer getCOSTO() {
        return COSTO;
    }

    public void setCOSTO(Integer cOSTO) {
        COSTO = cOSTO;
    }

    public Float getCOMISION() {
        return COMISION;
    }

    public void setCOMISION(Float comision) {
        COMISION = comision;
    }

    public LocalDateTime getHORA_INICIO() {
        return HORA_INICIO;
    }

    public void setHORA_INICIO(LocalDateTime hORA_INICIO) {
        HORA_INICIO = hORA_INICIO;
    }

    public LocalDateTime getHORA_FIN() {
        return HORA_FIN;
    }

    public void setHORA_FIN(LocalDateTime hORA_FIN) {
        HORA_FIN = hORA_FIN;
    }

    public VEHICULO getVEHICULO() {
        return VEHICULO;
    }

    public void setVEHICULO(VEHICULO vEHICULO) {
        VEHICULO = vEHICULO;
    }

    public USUARIO_SERVICIO getCliente() {
        return cliente;
    }

    public void setCliente(USUARIO_SERVICIO cliente) {
        this.cliente = cliente;
    }

    public USUARIO_CONDUCTOR getConductor() {
        return conductor;
    }

    public void setConductor(USUARIO_CONDUCTOR conductor) {
        this.conductor = conductor;
    }
}
 