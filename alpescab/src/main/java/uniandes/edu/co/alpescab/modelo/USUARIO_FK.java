package uniandes.edu.co.alpescab.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class USUARIO_FK implements Serializable  {
    @OneToOne
    @JoinColumn(name="CEDULA",referencedColumnName = "CEDULA")
    private PERSONA PERSONA;

    public USUARIO_FK(PERSONA cedula) {
        super();
        PERSONA = cedula;
    }

    public PERSONA getPERSONA() {
        return PERSONA;
    }

    public void setPERSONA(PERSONA pERSONA) {
        PERSONA = pERSONA;
    }
    
}
