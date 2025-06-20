package tpo.jugar.model.partido;

import jakarta.persistence.*;
import tpo.jugar.model.partido.estado.TipoDeEstadoDePartido;
import tpo.jugar.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private TipoDeEstadoDePartido estado;
    private Integer cantidadDeJugadores;

    @ManyToMany
    @JoinTable(
            name = "partido_usuario",
            joinColumns = @JoinColumn(name = "partido_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> jugadores;

    protected Partido() {}

    public Partido(Integer cantidadDeJugadores) {
        this.estado = TipoDeEstadoDePartido.NECESITAMOS_JUGADORES;
        this.cantidadDeJugadores = cantidadDeJugadores;
//        this.jugadores = new ArrayList<>();
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

//    public List<Usuario> getJugadores() {
//        return jugadores;
//    }
//
//    public void setJugadores(List<Usuario> jugadores) {
//        this.jugadores = jugadores;
//    }
}