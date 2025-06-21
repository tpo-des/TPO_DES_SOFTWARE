package tpo.jugar.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpo.jugar.dto.PartidoDto;
import tpo.jugar.mapper.PartidoMapper;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.service.JugadorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios/{usuarioId}/partidos")
public class UsuarioPartidoController {

    private final JugadorService jugadorService;

    public UsuarioPartidoController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public ResponseEntity<List<PartidoDto>> getPartidosByUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(
                jugadorService.getByUsuarioId(usuarioId)
                        .stream()
                        .map(Jugador::getPartido)
                        .map(PartidoMapper::toDto)
                        .toList()
        );
    }
}
