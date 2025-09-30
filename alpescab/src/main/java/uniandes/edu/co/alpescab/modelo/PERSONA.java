package uniandes.edu.co.alpescab.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSONA")
public class PERSONA {
    @Id
    @Column(unique = true, nullable = false)
    private String CEDULA;

    @Column(nullable = false)
    private String NOMBRE;
    
    private String CONTACTO;
    
    @JsonProperty("numero_celu")
    private String NUMERO_CELULAR;

    public PERSONA(String cedula, String nombre, String contacto, String numero_celu) {
        this.CEDULA = cedula;
        this.NOMBRE = nombre;
        this.CONTACTO = contacto;
        this.NUMERO_CELULAR = numero_celu;
    }

    public PERSONA() {
        ;
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String cedula) {
        CEDULA = cedula;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String nombre) {
        NOMBRE = nombre;
    }

    public String getCONTACTO() {
        return CONTACTO;
    }

    public void setCONTACTO(String contacto) {
        CONTACTO = contacto;
    }

    public String getNUMERO_CELULAR() {
        return NUMERO_CELULAR;
    }

    public void setNUMERO_CELULAR(String numero_celular) {
        NUMERO_CELULAR = numero_celular;
    }
}
