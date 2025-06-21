package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.JugadorDto;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.service.JugadorService;
import tpo.jugar.mapper.JugadorMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partidos/{partidoId}/jugadores")
public class PartidoJugadorController {

    private final JugadorService service;

    public PartidoJugadorController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<JugadorDto>> getJugadores(@PathVariable Long partidoId) {
        return ResponseEntity.ok(
                service.getByPartidoId(partidoId)
                        .stream()
                        .map(JugadorMapper::toDto)
                        .toList()
        );
    }

    @PostMapping
    ResponseEntity<JugadorDto> addJugador(@PathVariable Long partidoId, @RequestBody JugadorDto jugadorDto) {
        Jugador jugador = service.addJugador(partidoId, jugadorDto.getUsuarioId(), jugadorDto.getConfirmado());
        return ResponseEntity.ok(JugadorMapper.toDto(jugador));
    }
}
