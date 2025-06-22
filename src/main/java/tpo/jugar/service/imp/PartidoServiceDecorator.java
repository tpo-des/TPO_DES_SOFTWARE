package tpo.jugar.service.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.PartidoService;
import tpo.jugar.service.UsuarioNotificationService;
import tpo.jugar.service.UsuarioService;

import java.util.List;

@Service
@Primary
public class PartidoServiceDecorator implements PartidoService {

    private PartidoService delegate;
    private UsuarioService usuarioService;
    private UsuarioNotificationService usuarioNotificationService;

    public PartidoServiceDecorator(
            UsuarioService usuarioService,
            @Qualifier("DefaultImplementation") PartidoService delegate,
            UsuarioNotificationService usuarioNotificationService
    ) {
        this.usuarioService = usuarioService;
        this.delegate = delegate;
        this.usuarioNotificationService = usuarioNotificationService;
    }

    @Override
    public List<Partido> findAll() {
        return delegate.findAll();
    }

    @Override
    public List<Partido> findNecesitadosDeJugadoresBy(String ubicacion) {
        return delegate.findNecesitadosDeJugadoresBy(ubicacion);
    }

    @Override
    public Partido getById(long id) {
        return delegate.getById(id);
    }

    @Override
    public Partido create(Partido partido) {
        Partido partidoActualizado = delegate.create(partido);
        Deporte deporte = partido.getDeporte();
        usuarioService.findByDeporteFavorito(deporte)
                .forEach(usuario -> usuarioNotificationService
                        .notificarUsuarios(usuario, templateCrearPartido(partidoActualizado, usuario))
                );
        return partidoActualizado;
    }

    @Override
    public Partido update(Partido partido) {
        return delegate.update(partido);
    }

    @Override
    public Partido finalizar(long id) {
        Partido partidoActualizado = delegate.finalizar(id);
        partidoActualizado.getJugadores()
                .stream()
                .map(Jugador::getUsuario)
                .forEach(usuario -> usuarioNotificationService
                        .notificarUsuarios(usuario, templateFinalizarPartido(partidoActualizado, usuario)))
        ;
        return partidoActualizado;
    }

    @Override
    public Partido cancelar(long id) {
        Partido partidoActualizado = delegate.cancelar(id);
        partidoActualizado.getJugadores()
                .stream()
                .map(Jugador::getUsuario)
                .forEach(usuario -> usuarioNotificationService
                        .notificarUsuarios(usuario, templateCancelarPartido(partidoActualizado, usuario)))
        ;
        return partidoActualizado;
    }

    public String templateCrearPartido(Partido partido, Usuario usuario) {
        return """
                Hola %s,
                Se ha creado un nuevo partido en la ubicación %s, que comienza el %s.
                !No olvides unirte!
                """
                .formatted(
                        usuario.getNombreUsuario(),
                        partido.getUbicacion(),
                        partido.getFechaComienzo()
                );
    }

    public String templateFinalizarPartido(Partido partido, Usuario usuario) {
        return """
                Hola %s,
                Se termino el partido %s.
                !Gracias por jugar con nosotros!
                """
                .formatted(
                        usuario.getNombreUsuario(),
                        partido.getId()
                );
    }

    public String templateCancelarPartido(Partido partido, Usuario usuario) {
        return """
                Hola %s,
                Se cancelo el partido %s.
                !Lo sentimos!!
                """
                .formatted(
                        usuario.getNombreUsuario(),
                        partido.getId()
                );
    }
}
