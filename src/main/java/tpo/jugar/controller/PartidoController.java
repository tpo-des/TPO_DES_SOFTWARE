package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.JugadorDto;
import tpo.jugar.dto.PartidoDto;
import tpo.jugar.mapper.PartidoMapper;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.service.PartidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/partidos")
public class PartidoController {

    private final PartidoService service;

    PartidoController(PartidoService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<PartidoDto>> findBy(@RequestParam String ubicacion) {
        return ResponseEntity.ok(
                service.findNecesitadosDeJugadoresBy(ubicacion).stream()
                        .map(PartidoMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    ResponseEntity<PartidoDto> create(@RequestBody PartidoDto partidoDto) {
        Partido partido = new Partido(
                partidoDto.getCantidadDeJugadores(),
                partidoDto.getUbicacion()
        );
        return ResponseEntity.ok(PartidoMapper.toDto(service.create(partido)));
    }

    @GetMapping("/{id}")
    ResponseEntity<PartidoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(PartidoMapper.toDto(service.getById(id)));
    }

    @PutMapping("/{id}/finalizar")
    ResponseEntity<PartidoDto> finalizar(@PathVariable Long id) {
        Partido partido = service.finalizar(id);
        return ResponseEntity.ok(PartidoMapper.toDto(partido));
    }

    @PutMapping("/{id}/cancelar")
    ResponseEntity<PartidoDto> cancelar(@PathVariable Long id) {
        Partido partido = service.cancelar(id);
        return ResponseEntity.ok(PartidoMapper.toDto(partido));
    }
}
