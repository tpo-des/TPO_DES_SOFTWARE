package tpo.jugar.model.partido.matchmaking;

import tpo.jugar.exception.NotFoundException;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.PartidoService;

import java.util.Optional;

public class PorNivelEstrategiaMatchMaking implements EstrategiaDeMatchMaking {

    @Override
    public Partido matchearCon(PartidoService service, Usuario usuario) {
        Optional<Partido> partidos = service.findNivelMinimo(usuario.getNivel())
                .stream().findFirst();
        if (partidos.isPresent()) {
            return partidos.get();
        } else {
            throw new NotFoundException("No hay partidos disponibles para asignar al usuario: " + usuario.getId());
        }
    }
}
