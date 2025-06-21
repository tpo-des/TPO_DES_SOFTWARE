package tpo.jugar.model.jugador;

import jakarta.persistence.*;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.model.partido.Partido;

import java.util.Objects;

@Entity
public class Jugador {

    @EmbeddedId
    private JugadorId id;

    @MapsId("partidoId")
    @ManyToOne
    private Partido partido;

    @MapsId("usuarioId")
    @ManyToOne
    private Usuario usuario;

    @Column(name = "confirmado")
    private Boolean confirmado;


    public Jugador() {
    }

    public Jugador(Partido partido, Usuario usuario, Boolean confirmado) {
        this.id = new JugadorId(usuario.getId(), partido.getId());
        this.partido = partido;
        this.usuario = usuario;
        this.confirmado = confirmado;
    }

    public JugadorId getId() {
        return id;
    }

    public void setId(JugadorId id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(id, jugador.id) && Objects.equals(partido, jugador.partido) && Objects.equals(usuario, jugador.usuario) && Objects.equals(confirmado, jugador.confirmado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partido, usuario, confirmado);
    }
}