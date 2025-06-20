package tpo.jugar.dto;

import tpo.jugar.model.partido.estado.TipoEstadoPartido;

public class PartidoDto {
    private Long id;
    private TipoEstadoPartido estado;
    private Integer cantidadDeJugadores;

    public PartidoDto(Long id, TipoEstadoPartido estado, Integer cantidadDeJugadores) {
        this.id = id;
        this.estado = estado;
        this.cantidadDeJugadores = cantidadDeJugadores;
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

    public Integer getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }

    public void setCantidadDeJugadores(Integer cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }
}
