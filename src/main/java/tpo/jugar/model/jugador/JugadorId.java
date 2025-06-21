package tpo.jugar.model.jugador;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JugadorId implements Serializable {

    private Long usuarioId;
    private Long partidoId;

    public JugadorId() {}

    public JugadorId(Long usuarioId, Long partidoId) {
        this.usuarioId = usuarioId;
        this.partidoId = partidoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Long partidoId) {
        this.partidoId = partidoId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JugadorId jugadorId = (JugadorId) o;
        return Objects.equals(usuarioId, jugadorId.usuarioId) && Objects.equals(partidoId, jugadorId.partidoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, partidoId);
    }
}
