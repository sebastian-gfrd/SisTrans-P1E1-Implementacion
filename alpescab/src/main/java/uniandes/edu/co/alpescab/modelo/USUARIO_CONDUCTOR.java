package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO_CONDUCTOR")
public class USUARIO_CONDUCTOR extends USUARIO {

    private String CERTIFICADO;

    public USUARIO_CONDUCTOR(String cedula, String nombre, String contacto, String numero_celu, String correo, String estado, String certificado) {
        super(cedula, nombre, contacto, numero_celu, correo, estado);
        this.CERTIFICADO = certificado;
    }

    public USUARIO_CONDUCTOR() {
        super();
    }

    public String getCERTIFICADO() {
        return CERTIFICADO;
    }

    public void setCERTIFICADO(String cERTIFICADO) {
        CERTIFICADO = cERTIFICADO;
    }
}
