package tpo.jugar.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.JugadorDto;
import tpo.jugar.dto.MatchMakingRequestDto;
import tpo.jugar.dto.PartidoDto;
import tpo.jugar.mapper.JugadorMapper;
import tpo.jugar.mapper.PartidoMapper;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.service.JugadorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios/{usuarioId}/partidos")
public class UsuarioPartidoController {

    private final JugadorService service;

    public UsuarioPartidoController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PartidoDto>> getPartidosByUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(
                service.getByUsuarioId(usuarioId)
                        .stream()
                        .map(Jugador::getPartido)
                        .map(PartidoMapper::toDto)
                        .toList()
        );
    }


    @PutMapping("/{partidoId}/confirmar")
    ResponseEntity<JugadorDto> confirmarJugador(@PathVariable Long partidoId, @PathVariable Long usuarioId) {
        Jugador jugador = service.confirmarJugador(partidoId, usuarioId);
        return ResponseEntity.ok(JugadorMapper.toDto(jugador));
    }

    @PostMapping("/matchmaking")
    public ResponseEntity<PartidoDto> matchmaking(@PathVariable Long usuarioId, @RequestBody MatchMakingRequestDto dto) {
        Partido partido = service.asignarPartido(usuarioId, dto.getTipo());
        return ResponseEntity.ok(PartidoMapper.toDto(partido));
    }
}
