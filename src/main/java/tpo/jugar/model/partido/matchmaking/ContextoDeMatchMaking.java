package tpo.jugar.model.partido.matchmaking;

import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.JugadorService;
import tpo.jugar.service.PartidoService;

public class ContextoDeMatchMaking {
    private JugadorService jugadorService;
    private PartidoService partidoService;
    private EstrategiaDeMatchMaking estrategiaDeMatchMaking;

    public ContextoDeMatchMaking(JugadorService jugadorService, PartidoService partidoService) {
        this.jugadorService = jugadorService;
        this.partidoService = partidoService;
    }

    public Partido asignarPartidoA(Usuario usuario) {
        Partido partido = estrategiaDeMatchMaking.matchearCon(partidoService, usuario);
        jugadorService.addJugador(new Jugador(partido, usuario, false));
        return partido;
    }


    public void setEstrategiaMatchMaking(EstrategiaDeMatchMaking estrategiaDeMatchMaking) {
        this.estrategiaDeMatchMaking = estrategiaDeMatchMaking;
    }
}
