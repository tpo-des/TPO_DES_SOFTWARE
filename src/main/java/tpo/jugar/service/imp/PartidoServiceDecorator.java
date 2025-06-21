package tpo.jugar.service.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.notification.Notificator;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.PartidoService;
import tpo.jugar.service.UsuarioService;

import java.util.List;

@Service
@Primary
public class PartidoServiceDecorator implements PartidoService {

    private PartidoService delegate;
    private UsuarioService usuarioService;

    public PartidoServiceDecorator(UsuarioService usuarioService, @Qualifier("DefaultImplementation") PartidoService delegate) {
        this.usuarioService = usuarioService;
        this.delegate = delegate;
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
        List<Usuario> usuarios = usuarioService.findByDeporteFavorito(deporte);
        Notificator notificator = new Notificator();
        for (Usuario usuario : usuarios) {
            notificator.notificarEvento(
                    usuario,
                    "Nuevo partido creado para la fecha " + partido.getFechaComienzo() + " en " + partido.getUbicacion() + ". ¡No te lo pierdas!"
            );
        }
        return partidoActualizado;
    }

    @Override
    public Partido update(Partido partido) {
        return delegate.update(partido);
    }

    @Override
    public Partido finalizar(long id) {
        return delegate.finalizar(id);
    }

    @Override
    public Partido cancelar(long id) {
        return delegate.cancelar(id);
    }
}
