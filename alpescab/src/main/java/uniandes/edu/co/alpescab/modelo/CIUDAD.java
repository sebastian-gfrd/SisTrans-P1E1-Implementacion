package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CIUDAD")
public class CIUDAD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer   ID_CIUDAD;
    private String NOMBRE;
    private  String DEPARTAMENTO;
    public CIUDAD(String nOMBRE, String dEPARTAMENTO) {
        NOMBRE = nOMBRE;
        DEPARTAMENTO = dEPARTAMENTO;
    }
    public CIUDAD(){;}
    public Integer getID_CIUDAD() {
        return ID_CIUDAD;
    }
    public void setID_CIUDAD(Integer iD_CIUDAD) {
        ID_CIUDAD = iD_CIUDAD;
    }
    public String getNOMBRE() {
        return NOMBRE;
    }
    public void setNOMBRE(String nOMBRE) {
        NOMBRE = nOMBRE;
    }
    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }
    public void setDEPARTAMENTO(String dEPARTAMENTO) {
        DEPARTAMENTO = dEPARTAMENTO;
    }
    
}
 