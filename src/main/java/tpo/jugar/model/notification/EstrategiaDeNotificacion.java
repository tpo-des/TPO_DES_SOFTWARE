package tpo.jugar.model.notification;

import tpo.jugar.model.usuario.Usuario;

public interface EstrategiaDeNotificacion {
    void notificar(Usuario usuario, String mensaje);
}
