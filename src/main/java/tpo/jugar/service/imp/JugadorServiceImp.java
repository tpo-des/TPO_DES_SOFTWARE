package tpo.jugar.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.partido.estado.ContextoEstadoPartido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.JugadorService;
import tpo.jugar.service.PartidoService;
import tpo.jugar.service.UsuarioService;

import java.util.List;

@Service
public class JugadorServiceImp implements JugadorService {

    Logger logger = LoggerFactory.getLogger(PartidoServiceImp.class);

    private final PartidoService partidoService;
    private final UsuarioService usuarioService;

    public JugadorServiceImp(PartidoService partidoService, UsuarioService usuarioService) {
        this.partidoService = partidoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Jugador> getByPartidoId(long partidoId) {
        return partidoService.getById(partidoId).getJugadores();
    }

    @Override
    public List<Jugador> getByUsuarioId(long usuarioId) {
        Usuario usuario = usuarioService.getById(usuarioId);
        return usuario.getJuegaEn();
    }

    @Override
    public Jugador addJugador(long partidoId, long usuarioId, Boolean confirmado) {
        Partido partido = partidoService.getById(partidoId);
        Usuario usuario = usuarioService.getById(usuarioId);
       return addJugador(new Jugador(partido, usuario, confirmado));
    }

    public Jugador addJugador(Jugador jugador) {
        ContextoEstadoPartido ctx = new ContextoEstadoPartido(jugador.getPartido());
        String result = ctx.agregarJugador(jugador);
        logger.info(result);
        partidoService.update(ctx.getPartido());
        return jugador;
    }
}
