package tpo.jugar.service;

import tpo.jugar.model.jugador.Jugador;

import java.util.List;

public interface JugadorService {
    List<Jugador> getByPartidoId(long partidoId);
    Jugador addJugador(long partidoId, long usuarioId, Boolean confirmado);
}
