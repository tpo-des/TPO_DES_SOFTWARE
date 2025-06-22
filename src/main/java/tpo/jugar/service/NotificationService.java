package tpo.jugar.service;

import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;


public interface NotificationService {

    void notificarUsuarios(Usuario usuario, String mensaje);
    void notificarNuevoPartido(Partido partido);
}
