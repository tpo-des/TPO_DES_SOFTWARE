package tpo.jugar.repository;

import org.springframework.data.repository.CrudRepository;
import tpo.jugar.model.usuario.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}