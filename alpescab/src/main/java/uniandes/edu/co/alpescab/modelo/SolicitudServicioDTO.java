package uniandes.edu.co.alpescab.modelo;

import java.util.Map;

public class SolicitudServicioDTO {
    private Integer id_cliente;
    private Integer id_punto_partida;
    private Integer id_punto_llegada;
    private String tipo_servicio;
    private String modalidad;
    private Map<String, Object> detalles_servicio;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_punto_partida() {
        return id_punto_partida;
    }

    public void setId_punto_partida(Integer id_punto_partida) {
        this.id_punto_partida = id_punto_partida;
    }

    public Integer getId_punto_llegada() {
        return id_punto_llegada;
    }

    public void setId_punto_llegada(Integer id_punto_llegada) {
        this.id_punto_llegada = id_punto_llegada;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Map<String, Object> getDetalles_servicio() {
        return detalles_servicio;
    }

    public void setDetalles_servicio(Map<String, Object> detalles_servicio) {
        this.detalles_servicio = detalles_servicio;
    }
}
