package tpo.jugar.service.imp;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import tpo.jugar.dto.MyUserPrincipal;
import tpo.jugar.exception.NotFoundException;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {


    private UsuarioRepository repository;

    public UserDetailsServiceImp(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario user = repository.findByNombreUsuario(username);
        if (user == null) {
            throw new NotFoundException("Usuario no encontrado: " + username);
        }
        return new MyUserPrincipal(user.getNombreUsuario(), user.getPassword());
    }
}
