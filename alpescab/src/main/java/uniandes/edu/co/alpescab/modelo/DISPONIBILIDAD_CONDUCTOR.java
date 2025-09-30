package uniandes.edu.co.alpescab.modelo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name="DISPONIBILIDAD_CONDUCTOR")
public class DISPONIBILIDAD_CONDUCTOR {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISPONIBILIDAD_CONDUCTOR_SEQ")
    @SequenceGenerator(name = "DISPONIBILIDAD_CONDUCTOR_SEQ", sequenceName = "DISPONIBILIDAD_CONDUCTOR_SEQ", allocationSize = 1)
    private Integer id_disponibilidad;

    @ManyToOne
    @JoinColumn(name="id_usuario_conductor", referencedColumnName ="ID_USUARIO")
    private USUARIO_CONDUCTOR idUsuarioConductor;

    private String dia;
    private LocalDateTime horario_inicio;
    private LocalDateTime horario_fin;
    private String asignado;
    private String tipo_servicio;
    
    public DISPONIBILIDAD_CONDUCTOR(Integer id_disponibilidad, USUARIO_CONDUCTOR idUsuarioConductor, String dia,
            LocalDateTime horario_inicio, LocalDateTime horario_fin, String asignado, String tipo_servicio) {
        this.id_disponibilidad = id_disponibilidad;
        this.idUsuarioConductor = idUsuarioConductor;
        this.dia = dia;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
        this.asignado = asignado;
        this.tipo_servicio = tipo_servicio;
    }

    public DISPONIBILIDAD_CONDUCTOR()
    {;}

    public Integer getId_disponibilidad() {
        return id_disponibilidad;
    }

    public USUARIO_CONDUCTOR getIdUsuarioConductor() {
        return idUsuarioConductor;
    }

    public void setIdUsuarioConductor(USUARIO_CONDUCTOR idUsuarioConductor) {
        this.idUsuarioConductor = idUsuarioConductor;
    }

    public String getDia() {
        return dia;
    }

    public LocalDateTime getHorario_inicio() {
        return horario_inicio;
    }

    public LocalDateTime getHorario_fin() {
        return horario_fin;
    }

    public String getAsignado() {
        return asignado;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setId_disponibilidad(Integer id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }



    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHorario_inicio(LocalDateTime horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public void setHorario_fin(LocalDateTime horario_fin) {
        this.horario_fin = horario_fin;
    }

    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
    
    
}






