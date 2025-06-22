package tpo.jugar.service.imp;

import org.springframework.stereotype.Service;
import tpo.jugar.model.notification.EstrategiaDeNotificacion;
import tpo.jugar.model.notification.EstrategiaDeNotificacionFactory;
import tpo.jugar.model.notification.Notificator;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.UsuarioNotificationService;

@Service
public class UsuarioNotificationServiceImp implements UsuarioNotificationService {

    @Override
    public void notificarUsuarios(Usuario usuario, String mensaje) {
        Notificator notificator = new Notificator();
        EstrategiaDeNotificacion estrategia = EstrategiaDeNotificacionFactory.create(usuario.getPreferenciaNotificacion());
        notificator.setEstrategiaDeNotificacion(estrategia);
        notificator.notificarEvento(usuario, mensaje);
    }
}
