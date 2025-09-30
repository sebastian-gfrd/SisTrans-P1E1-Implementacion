package uniandes.edu.co.alpescab.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name="PUNTO_UBICACION")
public class PUNTO_UBICACION {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PUNTO_UBICACION_SEQ")
    @SequenceGenerator(name = "PUNTO_UBICACION_SEQ", sequenceName = "PUNTO_UBICACION_SEQ", allocationSize = 1)
    private Integer  ID_PUNTO;
    private String  DIRECCION_APROX;
    private double LATITUD ;
    private double LONGITUD;
    private String NOMBRE_LOCAL;
    @ManyToOne
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD") // FK hacia La ciudad
    private CIUDAD Ciudad;
    public PUNTO_UBICACION(String dIRECCION_APROX, double lATITUD, double lONGITUD, String nOMBRE_LOCAL,
            CIUDAD ciudad) {
        DIRECCION_APROX = dIRECCION_APROX;
        LATITUD = lATITUD;
        LONGITUD = lONGITUD;
        NOMBRE_LOCAL = nOMBRE_LOCAL;
        Ciudad = ciudad;
    }
    public PUNTO_UBICACION(){;}
    public Integer getID_PUNTO() {
        return ID_PUNTO;
    }
    public void setID_PUNTO(Integer iD_PUNTO) {
        ID_PUNTO = iD_PUNTO;
    }
    public String getDIRECCION_APROX() {
        return DIRECCION_APROX;
    }
    public void setDIRECCION_APROX(String dIRECCION_APROX) {
        DIRECCION_APROX = dIRECCION_APROX;
    }
    public double getLATITUD() {
        return LATITUD;
    }
    public void setLATITUD(double lATITUD) {
        LATITUD = lATITUD;
    }
    public double getLONGITUD() {
        return LONGITUD;
    }
    public void setLONGITUD(double lONGITUD) {
        LONGITUD = lONGITUD;
    }
    public String getNOMBRE_LOCAL() {
        return NOMBRE_LOCAL;
    }
    public void setNOMBRE_LOCAL(String nOMBRE_LOCAL) {
        NOMBRE_LOCAL = nOMBRE_LOCAL;
    }
    public CIUDAD getCiudad() {
        return Ciudad;
    }
    public void setCiudad(CIUDAD ciudad) {
        Ciudad = ciudad;
    }
    
    
}
 