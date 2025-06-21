package tpo.jugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpo.jugar.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}