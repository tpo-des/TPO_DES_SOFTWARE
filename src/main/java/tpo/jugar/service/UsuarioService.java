package tpo.jugar.service;

import tpo.jugar.model.usuario.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario getById(long id);
    Usuario create(Usuario usuario);
}
