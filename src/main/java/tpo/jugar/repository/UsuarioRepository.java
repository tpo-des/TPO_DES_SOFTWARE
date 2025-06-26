package tpo.jugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.usuario.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByDeporteFavorito(Deporte deporteFavorito);

    Usuario findByNombreUsuario(String nombreUsuario);
}