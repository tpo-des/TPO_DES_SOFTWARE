package tpo.jugar.model.partido.estado;

import tpo.jugar.exception.InvalidoEstadoPartidoException;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.usuario.Usuario;

public class EstadoConfirmado implements  EstadoPartido {

    @Override
    public String agregarJugador(ContextoEstadoPartido contexto, Jugador jugador) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }

    @Override
    public String finalizar(ContextoEstadoPartido contexto) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }

    @Override
    public String cancelar(ContextoEstadoPartido contexto) {
        contexto.setEstado(new EstadoConfirmado());
        return "El partido con id " + contexto.getPartido().getId() + " ha sido cancelado.";
    }

    @Override
    public String comenzar(ContextoEstadoPartido contexto) {
        contexto.setEstado(new EstadoEnJuego());
        return "El partido con id " + contexto.getPartido().getId() + " ha comenzado.";
    }
}
