package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO_CONDUCTOR")
public class USUARIO_CONDUCTOR {
    @EmbeddedId
    private USUARIO_SERVICIO_PK USUARIO_CONDUCTOR;
    private String CERTIFICADO;
    public USUARIO_CONDUCTOR(USUARIO uSUARIO_CONDUCTOR, String cERTIFICADO) {
        USUARIO_CONDUCTOR = new USUARIO_SERVICIO_PK(uSUARIO_CONDUCTOR);
        CERTIFICADO = cERTIFICADO;
    }
    public USUARIO_CONDUCTOR(){;}
    
    public USUARIO_SERVICIO_PK getUSUARIO_CONDUCTOR() {
        return USUARIO_CONDUCTOR;
    }
    public void setUSUARIO_CONDUCTOR(USUARIO_SERVICIO_PK uSUARIO_CONDUCTOR) {
        USUARIO_CONDUCTOR = uSUARIO_CONDUCTOR;
    }
    public String getCERTIFICADO() {
        return CERTIFICADO;
    }
    public void setCERTIFICADO(String cERTIFICADO) {
        CERTIFICADO = cERTIFICADO;
    }
    


    
}


