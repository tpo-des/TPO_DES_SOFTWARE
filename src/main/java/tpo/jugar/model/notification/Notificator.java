package tpo.jugar.model.notification;

import tpo.jugar.model.usuario.Usuario;

public class Notificator {

    private EstrategiaDeNotificacion estrategiaDeNotificacion;

    public void setEstrategiaDeNotificacion(EstrategiaDeNotificacion nueva) {
        this.estrategiaDeNotificacion = nueva;
    }

    void notificarEvento(Usuario usuario, String mensaje) {
        EstrategiaDeNotificacion estrategia = EstrategiaDeNotificacionFactory.create(TipoEstrategiaNotificacion.SMS);
        this.setEstrategiaDeNotificacion(estrategia);
        this.estrategiaDeNotificacion.notificar(usuario, mensaje);
    }
}
