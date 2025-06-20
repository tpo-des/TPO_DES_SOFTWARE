package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.UsuarioDto;
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
                        .map(UsuarioController::toDto)
                        .toList()
        );
    }

    @PostMapping
    ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(
                usuarioDto.getNombreUsuario(),
                usuarioDto.getEmail(),
                usuarioDto.getPassword()
        );
        return ResponseEntity.ok(toDto(service.create(usuario)));
    }

    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(service.getById(id)));
    }

    private static UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword()
        );
    }
}