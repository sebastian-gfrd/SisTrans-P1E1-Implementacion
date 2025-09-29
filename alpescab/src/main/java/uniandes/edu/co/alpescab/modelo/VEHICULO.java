package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name="VEHICULO")
public class VEHICULO {
    @Id
    private  String  PLACA;
    private String TIPO_VEHICULO;
    private String MARCA;
    private String MODELO;
    private String COLOR;
    private String CAPACIDAD;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO") // FK hacia PERSONA
    private USUARIO ID_USUARIO;
    @OneToOne 
    @JoinColumn(name="ID_CIUDAD",referencedColumnName="ID_CIUDAD")
    private CIUDAD ID_CIUDAD;



    
public VEHICULO(String pLACA, String tIPO_VEHICULO, String mARCA, String mODELO, String cOLOR, String cAPACIDAD,
            USUARIO iD_USUARIO, CIUDAD iD_CIUDAD) {
        PLACA = pLACA;
        TIPO_VEHICULO = tIPO_VEHICULO;
        MARCA = mARCA;
        MODELO = mODELO;
        COLOR = cOLOR;
        CAPACIDAD = cAPACIDAD;
        ID_USUARIO = iD_USUARIO;
        ID_CIUDAD = iD_CIUDAD;
    }
public VEHICULO(){;}



public String getPLACA() {
    return PLACA;
}




public void setPLACA(String pLACA) {
    PLACA = pLACA;
}




public String getTIPO_VEHICULO() {
    return TIPO_VEHICULO;
}




public void setTIPO_VEHICULO(String tIPO_VEHICULO) {
    TIPO_VEHICULO = tIPO_VEHICULO;
}




public String getMARCA() {
    return MARCA;
}




public void setMARCA(String mARCA) {
    MARCA = mARCA;
}




public String getMODELO() {
    return MODELO;
}




public void setMODELO(String mODELO) {
    MODELO = mODELO;
}




public String getCOLOR() {
    return COLOR;
}




public void setCOLOR(String cOLOR) {
    COLOR = cOLOR;
}




public String getCAPACIDAD() {
    return CAPACIDAD;
}




public void setCAPACIDAD(String cAPACIDAD) {
    CAPACIDAD = cAPACIDAD;
}




public USUARIO getID_USUARIO() {
    return ID_USUARIO;
}




public void setID_USUARIO(USUARIO iD_USUARIO) {
    ID_USUARIO = iD_USUARIO;
}




public CIUDAD getID_CIUDAD() {
    return ID_CIUDAD;
}




public void setID_CIUDAD(CIUDAD iD_CIUDAD) {
    ID_CIUDAD = iD_CIUDAD;
}

}


 