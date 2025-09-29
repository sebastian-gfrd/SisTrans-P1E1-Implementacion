package uniandes.edu.co.alpescab.modelo;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public abstract class USUARIO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer ID_USUARIO;
    @OneToOne
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA") // FK hacia PERSONA
    private PERSONA CEDULA;
    private String CORREO;
    @Column(name = "FECHA_REGISTRO", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date  FECHA_REGISTRO ;
    private String    ESTADO ;
    private Integer CALIFICACION;
public  USUARIO(Integer id,PERSONA Cedula, String correo,String estado){
    this.ID_USUARIO=id;
    this.CORREO=correo;
    this.ESTADO=estado;
    this.CEDULA=Cedula;
    this.CALIFICACION=5;
}
public USUARIO(){;}
public Integer getID_USUARIO() {
    return ID_USUARIO;
}
public void setID_USUARIO(Integer iD_USUARIO) {
    ID_USUARIO = iD_USUARIO;
}
public PERSONA getCEDULA() {
    return CEDULA;
}
public void setCEDULA(PERSONA cEDULA) {
    CEDULA = cEDULA;
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
