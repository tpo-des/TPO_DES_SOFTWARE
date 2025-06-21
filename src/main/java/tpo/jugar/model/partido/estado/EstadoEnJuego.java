package tpo.jugar.model.partido.estado;

import tpo.jugar.exception.InvalidoEstadoPartidoException;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.usuario.Usuario;

public class EstadoEnJuego implements  EstadoPartido {

    @Override
    public String agregarJugador(ContextoEstadoPartido contexto, Jugador jugador) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }

    @Override
    public String finalizar(ContextoEstadoPartido contexto) {
        contexto.setEstado(new EstadoFinalizado());
        return "El partido con id " + contexto.getPartido().getId() + " ha finalizado.";
    }

    @Override
    public String cancelar(ContextoEstadoPartido contexto) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }

    @Override
    public String comenzar(ContextoEstadoPartido contexto) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }
}
