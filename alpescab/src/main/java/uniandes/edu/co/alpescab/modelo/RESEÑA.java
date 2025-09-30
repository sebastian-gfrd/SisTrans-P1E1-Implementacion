package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "RESEÑA")
public class RESEÑA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESEÑA_SEQ")
    @SequenceGenerator(name = "RESEÑA_SEQ", sequenceName = "RESEÑA_SEQ", allocationSize = 1)
    private Integer ID_RESEÑA;

    @Column(name = "FECHA", columnDefinition = "DATE DEFAULT SYSDATE")
    private LocalDate FECHA;

    private String COMENTARIO;
    private Float CALIFICACION;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_AUTOR", referencedColumnName = "ID_USUARIO") // FK hacia usuario autor
    private USUARIO USUARIO_AUTOR;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_DESTINO", referencedColumnName = "ID_USUARIO") // FK hacia usario receptor
    private USUARIO USUARIO_DESTINO;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID_SERVICIO") // FK hacia el servicio corresspondiente
    private SERVICIO ID_SERVICIO;

    public RESEÑA(LocalDate fECHA, String cOMENTARIO, Float cALIFICACION, USUARIO uSUARIO_AUTOR, USUARIO uSUARIO_DESTINO,
            SERVICIO iD_SERVICIO) {
        this.FECHA = fECHA;
        this.COMENTARIO = cOMENTARIO;
        this.CALIFICACION = cALIFICACION;
        this.USUARIO_AUTOR = uSUARIO_AUTOR;
        this.USUARIO_DESTINO = uSUARIO_DESTINO;
        this.ID_SERVICIO = iD_SERVICIO;
    }

    public RESEÑA() {
        ;
    }

    public Integer getID_RESEÑA() {
        return ID_RESEÑA;
    }

    public void setID_RESEÑA(Integer iD_RESEÑA) {
        ID_RESEÑA = iD_RESEÑA;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate fECHA) {
        FECHA = fECHA;
    }

    public String getCOMENTARIO() {
        return COMENTARIO;
    }

    public void setCOMENTARIO(String cOMENTARIO) {
        COMENTARIO = cOMENTARIO;
    }

    public Float getCALIFICACION() {
        return CALIFICACION;
    }

    public void setCALIFICACION(Float cALIFICACION) {
        CALIFICACION = cALIFICACION;
    }

    public USUARIO getUSUARIO_AUTOR() {
        return USUARIO_AUTOR;
    }

    public void setUSUARIO_AUTOR(USUARIO uSUARIO_AUTOR) {
        USUARIO_AUTOR = uSUARIO_AUTOR;
    }

    public USUARIO getUSUARIO_DESTINO() {
        return USUARIO_DESTINO;
    }

    public void setUSUARIO_DESTINO(USUARIO uSUARIO_DESTINO) {
        USUARIO_DESTINO = uSUARIO_DESTINO;
    }

    public SERVICIO getID_SERVICIO() {
        return ID_SERVICIO;
    }

    public void setID_SERVICIO(SERVICIO iD_SERVICIO) {
        ID_SERVICIO = iD_SERVICIO;
    }
}
