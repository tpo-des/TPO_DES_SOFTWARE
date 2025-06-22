package tpo.jugar.model.notification;

import tpo.jugar.model.usuario.Usuario;

public class Notificator {

    private EstrategiaDeNotificacion estrategiaDeNotificacion;

    public void setEstrategiaDeNotificacion(EstrategiaDeNotificacion nueva) {
        this.estrategiaDeNotificacion = nueva;
    }

    public void notificarEvento(Usuario usuario, String mensaje) {
        this.estrategiaDeNotificacion.notificar(usuario, mensaje);
    }
}
