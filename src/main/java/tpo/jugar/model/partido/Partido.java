package tpo.jugar.model.partido;

import jakarta.persistence.*;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.estado.TipoEstadoPartido;
import tpo.jugar.model.usuario.NivelUsuario;
import tpo.jugar.model.usuario.Usuario;

import java.time.Duration;
import java.time.LocalDateTime;
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
    private Long duracionEnMinutos;
    private LocalDateTime fechaComienzo;
    private NivelUsuario nivelMinimo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deporte_id")
    private Deporte deporte;

    @OneToMany(
            mappedBy = "partido",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Jugador> jugadores = new ArrayList<>();

    protected Partido() {}

    public Partido(Integer cantidadDeJugadores, String ubicacion, Long duracionEnMinutos, LocalDateTime fechaComienzo, Deporte deporte) {
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.ubicacion = ubicacion;
        this.duracionEnMinutos = duracionEnMinutos;
        this.fechaComienzo = fechaComienzo;
        this.deporte = deporte;
        this.estado = TipoEstadoPartido.NECESITAMOS_JUGADORES;
        this.jugadores = new ArrayList<>();
    }

    public Partido(Long id, Deporte deporte, NivelUsuario nivelMinimo, LocalDateTime fechaComienzo, Long duracionEnMinutos, String ubicacion, Integer cantidadDeJugadores, TipoEstadoPartido estado) {
        this.id = id;
        this.deporte = deporte;
        this.nivelMinimo = nivelMinimo;
        this.fechaComienzo = fechaComienzo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.ubicacion = ubicacion;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.estado = estado;
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Long getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(Long duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public LocalDateTime getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(LocalDateTime fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public NivelUsuario getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(NivelUsuario nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public void removeJugador(Jugador jugador) {
        this.jugadores.remove(jugador);
    }

    public int getFaltantes() {
        return this.cantidadDeJugadores - this.jugadores.size();
    }

    public boolean faltanJugadores() {
        return getFaltantes() > 0;
    }
}