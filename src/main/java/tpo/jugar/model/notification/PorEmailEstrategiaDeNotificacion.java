package tpo.jugar.model.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.imp.UsuarioNotificationServiceImp;

public class PorEmailEstrategiaDeNotificacion implements EstrategiaDeNotificacion {

    Logger logger = LoggerFactory.getLogger(UsuarioNotificationServiceImp.class);

    @Override
    public void notificar(Usuario usuario, String mensaje) {
        logger.info("Enviando mensaje a {}: {}", usuario.getEmail(), mensaje);
    }
}
