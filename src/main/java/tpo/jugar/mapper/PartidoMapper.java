package tpo.jugar.mapper;

import tpo.jugar.dto.PartidoDto;
import tpo.jugar.model.partido.Partido;

public class PartidoMapper {

    public static PartidoDto toDto(Partido partido) {
        return new PartidoDto(
                partido.getId(),
                partido.getEstado(),
                partido.getCantidadDeJugadores(),
                partido.getUbicacion()
        );
    }
}
