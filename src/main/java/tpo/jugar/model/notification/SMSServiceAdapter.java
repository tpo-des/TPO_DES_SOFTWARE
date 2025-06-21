package tpo.jugar.model.notification;

import tpo.jugar.model.usuario.Usuario;

public interface SMSServiceAdapter {
    void enviarMensajeDeTexto(int numero, String mensaje);
}
