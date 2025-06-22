package tpo.jugar.service.imp;

import org.springframework.stereotype.Service;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.notification.TipoEstrategiaNotificacion;
import tpo.jugar.model.usuario.NivelUsuario;
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
    public List<Usuario> findByDeporteFavorito(Deporte deporte) {
        return repository.findByDeporteFavorito(deporte);
    }

    @Override
    public Usuario getById(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        Usuario usuarioConfigurado = setDefaults(usuario);
        return repository.save(usuarioConfigurado);
    }

    private Usuario setDefaults(Usuario usuario) {
        if (usuario.getNivel() == null) {
            usuario.setNivel(NivelUsuario.PRINCIPIANTE);
        }
        if (usuario.getPreferenciaNotificacion() == null) {
            usuario.setPreferenciaNotificacion(TipoEstrategiaNotificacion.EMAIL);
        }
        return usuario;
    }
}
