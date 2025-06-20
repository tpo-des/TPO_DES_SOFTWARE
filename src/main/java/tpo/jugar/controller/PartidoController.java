package tpo.jugar.controller;

import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.PartidoDto;
import tpo.jugar.dto.UsuarioDto;
import tpo.jugar.service.PartidoService;

import java.util.List;

@RestController
public class PartidoController {

    private final PartidoService service;

    PartidoController(PartidoService service) {
        this.service = service;
    }

    @GetMapping("/partidos")
    List<PartidoDto> all() {
        return service.findAll();
    }

    @PostMapping("/partidos")
    PartidoDto newUsuario(@RequestBody PartidoDto partidoDto) {
        return service.create(partidoDto);
    }

    @GetMapping("/partidos/{id}")
    PartidoDto one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/partidos/{id}")
    PartidoDto replaceUsuario(@RequestBody PartidoDto partidoDto, @PathVariable Long id) {
        return service.update(id, partidoDto);
    }

    @DeleteMapping("/partidos/{id}")
    PartidoDto deleteUsuario(@PathVariable Long id) {
        return service.delete(id);
    }
}
