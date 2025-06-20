package tpo.jugar.service;

import org.springframework.stereotype.Service;
import tpo.jugar.dto.PartidoDto;
import tpo.jugar.exception.NotFoundException;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.repository.PartidoRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PartidoService {

    private final PartidoRepository repository;

    public PartidoService(PartidoRepository repository) {
        this.repository = repository;
    }

    public List<PartidoDto> findAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::toDto)
                .toList();
    }

    private Partido findEntityById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el partido con id: " + id));
    }

    public PartidoDto findById(long id) {
        return toDto(findEntityById(id));
    }

    public PartidoDto create(PartidoDto partidoDto) {
        Partido partido = new Partido(
                partidoDto.getCantidadDeJugadores()
        );
        Partido savedPartido = repository.save(partido);
        return toDto(savedPartido);
    }

    public PartidoDto update(Long id, PartidoDto partidoDto) {
        Partido partido = findEntityById(id);

        partido.setEstado(partidoDto.getEstado());
        partido.setCantidadDeJugadores(partidoDto.getCantidadDeJugadores());

        Partido updatedPartido = repository.save(partido);
        return toDto(updatedPartido);
    }

    public PartidoDto delete(long id) {
        Partido partido = findEntityById(id);
        repository.delete(partido);
        return toDto(partido);
    }

    PartidoDto toDto(Partido partido) {
        return new PartidoDto(
                partido.getId(),
                partido.getEstado(),
                partido.getCantidadDeJugadores()
        );
    }
}
