package tpo.jugar.dto;

import tpo.jugar.model.partido.estado.TipoEstadoPartido;
import tpo.jugar.model.usuario.NivelUsuario;

import java.time.LocalDateTime;

public class PartidoDto {
    private Long id;
    private TipoEstadoPartido estado;
    private Integer cantidadDeJugadores;
    private String ubicacion;
    private Long duracionEnMinutos;
    private LocalDateTime fechaComienzo;
    private NivelUsuario nivelMinimo;
    private DeporteDto deporte;

    public PartidoDto(Long id, TipoEstadoPartido estado, Integer cantidadDeJugadores, String ubicacion, Long duracionEnMinutos, DeporteDto deporte, NivelUsuario nivelMinimo, LocalDateTime fechaComienzo) {
        this.id = id;
        this.estado = estado;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.ubicacion = ubicacion;
        this.duracionEnMinutos = duracionEnMinutos;
        this.deporte = deporte;
        this.nivelMinimo = nivelMinimo;
        this.fechaComienzo = fechaComienzo;
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

    public NivelUsuario getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(NivelUsuario nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public Long getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(Long duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public DeporteDto getDeporte() {
        return deporte;
    }

    public void setDeporte(DeporteDto deporte) {
        this.deporte = deporte;
    }

    public LocalDateTime getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(LocalDateTime fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }
}
