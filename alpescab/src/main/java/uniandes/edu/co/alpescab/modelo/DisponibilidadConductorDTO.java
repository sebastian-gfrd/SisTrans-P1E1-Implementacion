package uniandes.edu.co.alpescab.modelo;

import java.time.LocalDateTime;

public class DisponibilidadConductorDTO {
    private Integer idUsuarioConductor;
    private String dia;
    private LocalDateTime horario_inicio;
    private LocalDateTime horario_fin;
    private String tipo_servicio;

    public Integer getIdUsuarioConductor() {
        return idUsuarioConductor;
    }

    public void setIdUsuarioConductor(Integer idUsuarioConductor) {
        this.idUsuarioConductor = idUsuarioConductor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalDateTime getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(LocalDateTime horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public LocalDateTime getHorario_fin() {
        return horario_fin;
    }

    public void setHorario_fin(LocalDateTime horario_fin) {
        this.horario_fin = horario_fin;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
}
