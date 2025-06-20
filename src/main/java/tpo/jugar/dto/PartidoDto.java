package tpo.jugar.dto;

import tpo.jugar.model.partido.estado.TipoDeEstadoDePartido;

public class PartidoDto {
    private Long id;
    private TipoDeEstadoDePartido estado;
    private Integer cantidadDeJugadores;

    public PartidoDto(Long id, TipoDeEstadoDePartido estado, Integer cantidadDeJugadores) {
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

    public TipoDeEstadoDePartido getEstado() {
        return estado;
    }

    public void setEstado(TipoDeEstadoDePartido estado) {
        this.estado = estado;
    }

    public Integer getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }

    public void setCantidadDeJugadores(Integer cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }
}
