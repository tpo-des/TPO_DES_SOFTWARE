package tpo.jugar.service;

import org.springframework.stereotype.Service;
import tpo.jugar.dto.UsuarioDto;
import tpo.jugar.exception.NotFoundException;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioDto> findAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::toDto)
                .toList();
    }

    private Usuario findEntityById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario con id: " + id));
    }

    public UsuarioDto findById(long id) {
        return toDto(findEntityById(id));
    }

    public UsuarioDto create(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(
                usuarioDto.getNombreUsuario(),
                usuarioDto.getEmail(),
                usuarioDto.getPassword()
        );
        Usuario savedUsuario = repository.save(usuario);
        return toDto(savedUsuario);
    }

    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = findEntityById(id);

        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(usuarioDto.getPassword());

        Usuario updatedUsuario = repository.save(usuario);
        return toDto(updatedUsuario);
    }

    public UsuarioDto delete(long id) {
        Usuario usuario = findEntityById(id);
        repository.delete(usuario);
        return toDto(usuario);
    }

    private UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword()
        );
    }
}
