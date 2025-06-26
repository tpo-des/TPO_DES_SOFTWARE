package tpo.jugar.service;

import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.partido.matchmaking.TipoEstrategiaMatchMaking;

import java.util.List;

public interface JugadorService {
    List<Jugador> getByPartidoId(long partidoId);
    Jugador addJugador(long partidoId, long usuarioId, Boolean confirmado);
    Jugador addJugador(Jugador jugador);
    List<Jugador> getByUsuarioId(long usuarioId);
    Jugador confirmarJugador(long partidoId, long usuarioId);
    Partido asignarPartido(long usuarioId, TipoEstrategiaMatchMaking tipoEstrategiaMatchMaking);
}
