package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.JugadorDto;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.service.JugadorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partidos/{partidoId}/jugadores")
public class JugadorController {

    private final JugadorService service;

    public JugadorController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<JugadorDto>> getJugadores(@PathVariable Long partidoId) {
        return ResponseEntity.ok(
                service.getByPartidoId(partidoId)
                        .stream()
                        .map(JugadorController::toDto)
                        .toList()
        );
    }

    @PostMapping
    ResponseEntity<JugadorDto> addJugador(@PathVariable Long partidoId, @RequestBody JugadorDto jugadorDto) {
        Jugador jugador = service.addJugador(partidoId, jugadorDto.getUsuarioId(), jugadorDto.getConfirmado());
        return ResponseEntity.ok(toDto(jugador));
    }

    private static JugadorDto toDto(Jugador jugador) {
        return new JugadorDto(
                jugador.getPartido().getId(),
                jugador.getUsuario().getId(),
                jugador.getConfirmado()
        );
    }
}
