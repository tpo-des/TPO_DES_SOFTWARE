package tpo.jugar.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tpo.jugar.dto.UsuarioDto;
import tpo.jugar.service.UsuarioService;

import java.util.List;

@RestController
class UsuarioController {

    private final UsuarioService service;

    UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarios")
    List<UsuarioDto> all() {
        return service.findAll();
    }

    @PostMapping("/usuarios")
    UsuarioDto newUsuario(@RequestBody UsuarioDto usuarioDto) {
        return service.create(usuarioDto);
    }

    @GetMapping("/usuarios/{id}")
    UsuarioDto one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/usuarios/{id}")
    UsuarioDto replaceUsuario(@RequestBody UsuarioDto usuarioDto, @PathVariable Long id) {
        return service.update(id, usuarioDto);
    }

    @DeleteMapping("/usuarios/{id}")
    UsuarioDto deleteUsuario(@PathVariable Long id) {
        return service.delete(id);
    }
}