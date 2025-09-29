package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "SERVICIO")
public class SERVICIO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  ID_SERVICIO ;
    private Integer Nivel;
    private String MODALIDAD;
    private Integer DISTANCIA_KM;
    private Integer COSTO;
    private LocalDateTime HORA_INICIO;
    private LocalDateTime HORA_FIN;
    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "PLACA") // FK hacia VEHICULO
    private VEHICULO VEHICULO;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO ", referencedColumnName = "ID_USUARIO") // FK hacia USUARIO
    private USUARIO_SERVICIO USUARIO;
     @ManyToOne
    @JoinColumn(name = "ID_CONDUCTOR", referencedColumnName = "ID_USUARIO") // FK hacia CONDUCTOR
    private USUARIO_CONDUCTOR CONDUCTOR;
     public SERVICIO(Integer nivel, String mODALIDAD, Integer dISTANCIA_KM, Integer cOSTO, LocalDateTime hORA_INICIO,
            LocalDateTime hORA_FIN, VEHICULO vEHICULO,
            USUARIO_SERVICIO uSUARIO, USUARIO_CONDUCTOR cONDUCTOR) {
        Nivel = nivel;
        MODALIDAD = mODALIDAD;
        DISTANCIA_KM = dISTANCIA_KM;
        COSTO = cOSTO;
        HORA_INICIO = hORA_INICIO;
        HORA_FIN = hORA_FIN;
        VEHICULO = vEHICULO;
        USUARIO = uSUARIO;
        CONDUCTOR = cONDUCTOR;
     }
      public SERVICIO(){;}
     public Integer getID_SERVICIO() {
         return ID_SERVICIO;
     }
     public void setID_SERVICIO(Integer iD_SERVICIO) {
         ID_SERVICIO = iD_SERVICIO;
     }
     public Integer getNivel() {
         return Nivel;
     }
     public void setNivel(Integer nivel) {
         Nivel = nivel;
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
     public USUARIO_SERVICIO getUSUARIO() {
         return USUARIO;
     }
     public void setUSUARIO(USUARIO_SERVICIO uSUARIO) {
         USUARIO = uSUARIO;
     }
     public USUARIO_CONDUCTOR getCONDUCTOR() {
         return CONDUCTOR;
     }
     public void setCONDUCTOR(USUARIO_CONDUCTOR cONDUCTOR) {
         CONDUCTOR = cONDUCTOR;
     }

}
 