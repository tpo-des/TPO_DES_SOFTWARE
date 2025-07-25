package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.UsuarioDto;
import tpo.jugar.mapper.UsuarioMapper;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
class UsuarioController {

    private final UsuarioService service;

    UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<UsuarioDto>> all() {
        return ResponseEntity.ok(
                service.findAll()
                        .stream()
                        .map(UsuarioMapper::toDto)
                        .toList()
        );
    }

    @PostMapping
    ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDto);
        return ResponseEntity.ok(UsuarioMapper.toDto(service.create(usuario)));
    }

    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> getById(@PathVariable Long id) {
        Usuario usuario = service.getById(id);
        UsuarioDto usuarioDto = UsuarioMapper.toDto(usuario);
        return ResponseEntity.ok(usuarioDto);
    }
}