package tpo.jugar.model.partido.matchmaking;

import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.PartidoService;

public interface EstrategiaDeMatchMaking {
    Partido matchearCon(PartidoService service, Usuario usuario);
}
