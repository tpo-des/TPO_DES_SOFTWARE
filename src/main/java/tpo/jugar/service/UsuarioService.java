package tpo.jugar.service;

import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.usuario.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    List<Usuario> findByDeporteFavorito(Deporte deporte);
    Usuario getById(long id);
    Usuario create(Usuario usuario);
}
