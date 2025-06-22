package tpo.jugar.service;

import tpo.jugar.model.usuario.Usuario;


public interface UsuarioNotificationService {

    void notificarUsuarios(Usuario usuario, String mensaje);
}
