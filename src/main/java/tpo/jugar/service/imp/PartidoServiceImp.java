package tpo.jugar.service.imp;

import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tpo.jugar.model.event.PartidoCambioEstadoEvento;
import tpo.jugar.model.event.PartidoCreadoEvento;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.partido.estado.ContextoEstadoPartido;
import tpo.jugar.model.partido.estado.TipoEstadoPartido;
import tpo.jugar.model.usuario.NivelUsuario;
import tpo.jugar.repository.PartidoRepository;
import tpo.jugar.service.PartidoService;

import java.util.List;

@Service
public class PartidoServiceImp implements PartidoService {

    Logger logger = LoggerFactory.getLogger(PartidoServiceImp.class);

    private final PartidoRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    public PartidoServiceImp(PartidoRepository repository, ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Partido> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Partido> findNecesitadosDeJugadoresBy(String ubicacion) {
        return repository.findByEstadoAndUbicacion(TipoEstadoPartido.NECESITAMOS_JUGADORES, ubicacion);
    }

    @Override
    public List<Partido> findNivelMinimo(NivelUsuario nivel) {
        return repository.findByNivelMinimoGreaterThanEqual(nivel);
    }

    @Override
    public Partido getById(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Partido create(Partido partido) {
        if (partido.getNivelMinimo() == null) {
            partido.setNivelMinimo(NivelUsuario.PRINCIPIANTE);
        }
        Partido partidoGuardado = repository.save(partido);
        eventPublisher.publishEvent(new PartidoCreadoEvento(this, partidoGuardado));
        return partidoGuardado;
    }

    @Override
    public Partido update(Partido partido) {
        return repository.save(partido);
    }

    private ContextoEstadoPartido getEstadoPartido(long id) {
        Partido partido = getById(id);
        return new ContextoEstadoPartido(eventPublisher, partido);
    }

    @Override
    public Partido finalizar(long id) {
        ContextoEstadoPartido ctx = getEstadoPartido(id);
        String result = ctx.finalizar();
        logger.info(result);
        return repository.save(ctx.getPartido());
    }

    @Override
    public Partido cancelar(long id) {
        ContextoEstadoPartido ctx = getEstadoPartido(id);
        String result = ctx.cancelar();
        logger.info(result);
        return repository.save(ctx.getPartido());
    }
}
