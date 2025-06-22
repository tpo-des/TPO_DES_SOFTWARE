package tpo.jugar.model.event;

import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.service.NotificationService;

public class PartidoCreadoEvento extends AbstractPartidoEvento {

    public PartidoCreadoEvento(Object source, Partido partido) {
        super(source, partido);
    }

    @Override
    public void ejecutar(NotificationService notificationService) {
        notificationService.notificarNuevoPartido(getPartido());
    }
}
