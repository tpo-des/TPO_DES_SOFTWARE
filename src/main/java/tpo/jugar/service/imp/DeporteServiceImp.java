package tpo.jugar.service.imp;

import org.springframework.stereotype.Service;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.repository.DeporteRepository;
import tpo.jugar.service.DeporteService;

import java.util.List;

@Service
public class DeporteServiceImp implements DeporteService {

    private final DeporteRepository repository;

    public DeporteServiceImp(DeporteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Deporte> all() {
        return repository.findAll();
    }

    @Override
    public Deporte findById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Deporte create(Deporte deporte) {
        return repository.save(deporte);
    }
}
