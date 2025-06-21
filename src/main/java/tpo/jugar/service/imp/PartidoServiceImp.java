package tpo.jugar.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.partido.estado.ContextoEstadoPartido;
import tpo.jugar.model.partido.estado.TipoEstadoPartido;
import tpo.jugar.repository.PartidoRepository;
import tpo.jugar.service.PartidoService;

import java.util.List;

@Service
public class PartidoServiceImp implements PartidoService {

    Logger logger = LoggerFactory.getLogger(PartidoServiceImp.class);

    private final PartidoRepository repository;

    public PartidoServiceImp(PartidoRepository repository) {
        this.repository = repository;
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
    public Partido getById(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Partido create(Partido partido) {
        return repository.save(partido);
    }

    @Override
    public Partido update(Partido partido) {
        return repository.save(partido);
    }

    private ContextoEstadoPartido getEstadoPartido(long id) {
        Partido partido = getById(id);
        return new ContextoEstadoPartido(partido);
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
