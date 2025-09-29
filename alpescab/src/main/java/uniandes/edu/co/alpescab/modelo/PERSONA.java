package uniandes.edu.co.alpescab.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="PERSONA")
public abstract class PERSONA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  String CEDULA ;

    private String   NOMBRE ;
    private  String  CONTACTO ;
    private String   NUMERO_CELULAR ;
    public PERSONA (String cedula,String nombre, String contacto,String numero_celu){

        this.CEDULA= cedula;
        this.NOMBRE=nombre;
        this.CONTACTO=contacto;
        this.NUMERO_CELULAR=numero_celu;
    }
    public PERSONA(){;}

    public String getCEDULA() {
        return CEDULA;
    }
    public void setCEDULA(String cEDULA) {
        CEDULA = cEDULA;
    }
    public String getNOMBRE() {
        return NOMBRE;
    }
    public void setNOMBRE(String nOMBRE) {
        NOMBRE = nOMBRE;
    }
    public String getCONTACTO() {
        return CONTACTO;
    }
    public void setCONTACTO(String cONTACTO) {
        CONTACTO = cONTACTO;
    }
    public String getNUMERO_CELULAR() {
        return NUMERO_CELULAR;
    }
    public void setNUMERO_CELULAR(String nUMERO_CELULAR) {
        NUMERO_CELULAR = nUMERO_CELULAR;
    }
    


}
