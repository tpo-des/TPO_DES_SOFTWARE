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
        String resultad = estado.finalizar(this);
        return resultad;
    }

    public String cancelar() {
        return estado.cancelar(this);
    }

    public String agregarJugador(Jugador jugador) {
        return estado.agregarJugador(this, jugador);
    }

    public String confirmar(Jugador jugador) {
        return estado.confirmar(this, jugador);
    }

    public EstadoPartido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
        this.partido.setEstado(EstadoFactory.crear(estado));
    }
}
