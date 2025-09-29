package uniandes.edu.co.alpescab.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class USUARIO_SERVICIO_PK   implements Serializable{
    @OneToOne
    @JoinColumn(name="ID_USUARIO",referencedColumnName = "ID_USUARIO")
    private USUARIO USUARIO;
    

    
    public USUARIO_SERVICIO_PK(USUARIO uSUARIO) {
        USUARIO = uSUARIO;
    
    }
    public USUARIO getUSUARIO() {
        return USUARIO;
    }
    public void setUSUARIO(USUARIO uSUARIO) {
        USUARIO = uSUARIO;
    }
 
    


     
}
