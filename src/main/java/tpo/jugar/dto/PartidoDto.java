package tpo.jugar.dto;

import tpo.jugar.model.partido.estado.TipoEstadoPartido;

public class PartidoDto {
    private Long id;
    private TipoEstadoPartido estado;
    private Integer cantidadDeJugadores;
    private String ubicacion;

    public PartidoDto(Long id, TipoEstadoPartido estado, Integer cantidadDeJugadores, String ubicacion) {
        this.id = id;
        this.estado = estado;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEstadoPartido getEstado() {
        return estado;
    }

    public void setEstado(TipoEstadoPartido estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }

    public void setCantidadDeJugadores(Integer cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }
}
