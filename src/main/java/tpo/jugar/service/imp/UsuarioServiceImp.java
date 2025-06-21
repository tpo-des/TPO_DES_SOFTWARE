package tpo.jugar.service.imp;

import org.springframework.stereotype.Service;
import tpo.jugar.exception.NotFoundException;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.repository.UsuarioRepository;
import tpo.jugar.service.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImp(UsuarioRepository repository) {
        this.repository = repository;
    }


    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario con id: " + id));
    }

    @Override
    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }
}
