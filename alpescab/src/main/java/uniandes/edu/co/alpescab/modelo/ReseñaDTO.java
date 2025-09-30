package uniandes.edu.co.alpescab.modelo;

public class ReseñaDTO {
    private Integer id_servicio;
    private Integer id_usuario_autor;
    private Integer id_usuario_destino;
    private String comentario;
    private Float calificacion;

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Integer getId_usuario_autor() {
        return id_usuario_autor;
    }

    public void setId_usuario_autor(Integer id_usuario_autor) {
        this.id_usuario_autor = id_usuario_autor;
    }

    public Integer getId_usuario_destino() {
        return id_usuario_destino;
    }

    public void setId_usuario_destino(Integer id_usuario_destino) {
        this.id_usuario_destino = id_usuario_destino;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }
}
