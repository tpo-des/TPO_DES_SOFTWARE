package tpo.jugar.model.partido.estado;

import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;

public class ContextoEstadoPartido {
    private Partido partido;
    private EstadoPartido estado;

    public ContextoEstadoPartido(Partido partido) {
        this.partido = partido;
        this.estado = EstadoFactory.crear(partido.getEstado());
    }

    public Partido getPartido() {
        return partido;
    }

    public String finalizar() {
        return estado.finalizar(this);
    }

    public String cancelar() {
        return estado.cancelar(this);
    }

    public String agregarJugador(Jugador jugador) {
        return estado.agregarJugador(this, jugador);
    }

    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
        this.partido.setEstado(EstadoFactory.crear(estado));
    }
}
