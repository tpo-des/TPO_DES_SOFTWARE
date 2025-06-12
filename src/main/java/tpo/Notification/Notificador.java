package tpo.Notification;

import tpo.modelo.Usuario;

public interface Notificador {

    void enviar(Usuario usuario, String mensaje);
    
}
