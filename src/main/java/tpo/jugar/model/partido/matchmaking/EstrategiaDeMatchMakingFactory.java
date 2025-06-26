package tpo.jugar.model.partido.matchmaking;

import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.PartidoService;

public class EstrategiaDeMatchMakingFactory {

    public static EstrategiaDeMatchMaking crear(TipoEstrategiaMatchMaking tipoEstrategiaMatchMaking) {
        return switch (tipoEstrategiaMatchMaking) {
            case POR_NIVEL -> new PorNivelEstrategiaMatchMaking();
            case POR_UBICACION -> new PorUbicacionEstrategiaDeMatchMaking();
        };
    }

}
