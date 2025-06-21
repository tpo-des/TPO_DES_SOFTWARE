package tpo.jugar.model.partido;

import jakarta.persistence.*;
import tpo.jugar.model.partido.estado.TipoEstadoPartido;
import tpo.jugar.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private TipoEstadoPartido estado;
    private Integer cantidadDeJugadores;
    private String ubicacion;

    @ManyToMany
    @JoinTable(
            name = "partido_usuario",
            joinColumns = @JoinColumn(name = "partido_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> jugadores;

    protected Partido() {}

    public Partido(Integer cantidadDeJugadores, String ubicacion) {
        this.estado = TipoEstadoPartido.NECESITAMOS_JUGADORES;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.ubicacion = ubicacion;
        this.jugadores = new ArrayList<>();
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

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Usuario> jugadores) {
        this.jugadores = jugadores;
    }

    public void addJugador(Usuario jugador) {
        this.jugadores.add(jugador);
    }

    public void removeJugador(Usuario jugador) {
        this.jugadores.remove(jugador);
    }

    public int getFaltantes() {
        return this.cantidadDeJugadores - this.jugadores.size();
    }

    public boolean faltanJugadores() {
        return getFaltantes() > 0;
    }
}