package tpo.jugar.service.imp;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.event.AbstractPartidoEvento;
import tpo.jugar.model.notification.EstrategiaDeNotificacion;
import tpo.jugar.model.notification.EstrategiaDeNotificacionFactory;
import tpo.jugar.model.notification.Notificator;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.NotificationService;
import tpo.jugar.service.UsuarioService;

@Service
public class NotificationServiceImp implements NotificationService {

    private final UsuarioService usuarioService;

    public NotificationServiceImp(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void notificarUsuarios(Usuario usuario, String mensaje) {
        Notificator notificator = new Notificator();
        EstrategiaDeNotificacion estrategia = EstrategiaDeNotificacionFactory.create(usuario.getPreferenciaNotificacion());
        notificator.setEstrategiaDeNotificacion(estrategia);
        notificator.notificarEvento(usuario, mensaje);
    }

    @Override
    public void notificarNuevoPartido(Partido partido) {
        Deporte deporte = partido.getDeporte();
        usuarioService.findByDeporteFavorito(deporte)
                .forEach(usuario -> notificarUsuarios(usuario, templateCrearPartido(partido, usuario)));
    }

    @EventListener
    public void handlePartidoEvento(AbstractPartidoEvento event) {
        event.ejecutar(this);
    }

    private String templateCrearPartido(Partido partido, Usuario usuario) {
        return String.format("Hola %s, se ha creado un nuevo partido de %s. fecha: %s, ubicacion: %s",
                usuario.getNombreUsuario(), partido.getDeporte().getId(), partido.getFechaComienzo(), partido.getUbicacion());
    }

}
