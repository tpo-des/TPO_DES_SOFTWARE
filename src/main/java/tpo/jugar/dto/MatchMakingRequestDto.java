package tpo.jugar.dto;

import tpo.jugar.model.partido.matchmaking.EstrategiaDeMatchMaking;
import tpo.jugar.model.partido.matchmaking.TipoEstrategiaMatchMaking;

public class MatchMakingRequestDto {
    TipoEstrategiaMatchMaking tipo;

    public TipoEstrategiaMatchMaking getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstrategiaMatchMaking tipo) {
        this.tipo = tipo;
    }
}
