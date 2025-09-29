package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TARJETA_CREDITO")
public  abstract class TARJETA_CREDITO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID_TARJETA;
    private String NUMERO_TARJETA;
    private String  NOMBRE_EN_TARJETA;
    private LocalDate FECHA_VENCIMIENTO;
    private String CODIGO_SEGURIDAD;
    public TARJETA_CREDITO(String nUMERO_TARJETA, String nOMBRE_EN_TARJETA, LocalDate fECHA_VENCIMIENTO,
            String cODIGO_SEGURIDAD) {
        NUMERO_TARJETA = nUMERO_TARJETA;
        NOMBRE_EN_TARJETA = nOMBRE_EN_TARJETA;
        FECHA_VENCIMIENTO = fECHA_VENCIMIENTO;
        CODIGO_SEGURIDAD = cODIGO_SEGURIDAD;
    }
    public TARJETA_CREDITO(){;}
    public Integer getID_TARJETA() {
        return ID_TARJETA;
    }
    public void setID_TARJETA(Integer iD_TARJETA) {
        ID_TARJETA = iD_TARJETA;
    }
    public String getNUMERO_TARJETA() {
        return NUMERO_TARJETA;
    }
    public void setNUMERO_TARJETA(String nUMERO_TARJETA) {
        NUMERO_TARJETA = nUMERO_TARJETA;
    }
    public String getNOMBRE_EN_TARJETA() {
        return NOMBRE_EN_TARJETA;
    }
    public void setNOMBRE_EN_TARJETA(String nOMBRE_EN_TARJETA) {
        NOMBRE_EN_TARJETA = nOMBRE_EN_TARJETA;
    }
    public LocalDate getFECHA_VENCIMIENTO() {
        return FECHA_VENCIMIENTO;
    }
    public void setFECHA_VENCIMIENTO(LocalDate fECHA_VENCIMIENTO) {
        FECHA_VENCIMIENTO = fECHA_VENCIMIENTO;
    }
    public String getCODIGO_SEGURIDAD() {
        return CODIGO_SEGURIDAD;
    }
    public void setCODIGO_SEGURIDAD(String cODIGO_SEGURIDAD) {
        CODIGO_SEGURIDAD = cODIGO_SEGURIDAD;
    }
    

    
   
    
}


