package tpo.jugar.mapper;

import tpo.jugar.dto.JugadorDto;
import tpo.jugar.model.jugador.Jugador;

public class JugadorMapper {

    public static JugadorDto toDto(Jugador jugador) {
        return new JugadorDto(
                jugador.getPartido().getId(),
                jugador.getUsuario().getId(),
                jugador.getConfirmado()
        );
    }
}
