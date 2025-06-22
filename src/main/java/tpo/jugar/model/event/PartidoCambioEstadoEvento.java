package tpo.jugar.model.event;

import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.NotificationService;

public class PartidoCambioEstadoEvento extends AbstractPartidoEvento {

    public PartidoCambioEstadoEvento(Object source, Partido partido) {
        super(source, partido);
    }

    @Override
    public void ejecutar(NotificationService notificationService) {
        Partido partido = getPartido();
        for (Jugador jugador : partido.getJugadores()) {
            Usuario usuario = jugador.getUsuario();
            String mensaje = template(partido, usuario);
            if (mensaje != null) {
                notificationService.notificarUsuarios(usuario, mensaje);
            }
        }
    }

    private static String template(Partido partido, Usuario usuario) {
        return switch (partido.getEstado()) {
            case NECESITAMOS_JUGADORES -> null;
            case PARTIDO_ARMADO -> """
                Hola %s, El partido %s ya esta armado. !A disfrutar!
                """.formatted(usuario.getNombreUsuario(), partido.getId());
            case CONFIRMADO -> """
                Hola %s, El partido %s ya esta confirmado. !A disfrutar!
                """.formatted(usuario.getNombreUsuario(), partido.getId());
            case EN_JUEGO -> """
                Hola %s, El partido %s ya comenzo. !A disfrutar!
                """.formatted(usuario.getNombreUsuario(), partido.getId());
            case FINALIZADO -> """
                Hola %s, Se termino el partido %s. !Gracias por jugar con nosotros!
                """.formatted(usuario.getNombreUsuario(), partido.getId());
            case CANCELADO -> """
                Hola %s, Se cancelo el partido %s. !Lo sentimos!!
                """.formatted(usuario.getNombreUsuario(), partido.getId());
        };
    }
}