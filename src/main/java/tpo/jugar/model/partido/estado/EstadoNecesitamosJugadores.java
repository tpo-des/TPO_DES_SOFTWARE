package tpo.jugar.model.partido.estado;

import tpo.jugar.exception.InvalidoEstadoPartidoException;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.usuario.Usuario;

public class EstadoNecesitamosJugadores implements EstadoPartido {

    @Override
    public String agregarJugador(ContextoEstadoPartido contexto, Jugador jugador) {
        contexto.getPartido().addJugador(jugador);
        if (!contexto.getPartido().faltanJugadores()) {
            contexto.setEstado(new EstadoPartidoArmado());
            return "El partido con id " + contexto.getPartido().getId() + " ha sido armado.";
        }
        return "Faltan " + contexto.getPartido().getFaltantes() + " jugadores para armar el partido con id " + contexto.getPartido().getId() + ".";
    }

    @Override
    public String finalizar(ContextoEstadoPartido contexto) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }

    @Override
    public String cancelar(ContextoEstadoPartido contexto) {
        contexto.setEstado(new EstadoCancelado());
        return "El partido con id " + contexto.getPartido().getId() + " ha sido cancelado.";
    }

    @Override
    public String comenzar(ContextoEstadoPartido contexto) {
        throw new InvalidoEstadoPartidoException(contexto.getPartido());
    }

    @Override
    public String confirmar(ContextoEstadoPartido contexto, Jugador jugador) {
        if (!contexto.getPartido().getJugadores().contains(jugador)) {
            throw new InvalidoEstadoPartidoException(contexto.getPartido());
        }
        return "Jugador " + jugador.getUsuario().getNombreUsuario() + " confirmado en el partido con id " + contexto.getPartido().getId() + ".";
    }
}
