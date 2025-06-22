package tpo.jugar.model.event;

import org.springframework.context.ApplicationEvent;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.service.NotificationService;

public abstract class AbstractPartidoEvento extends ApplicationEvent {
    private Partido partido;

    public AbstractPartidoEvento(Object source, Partido partido) {
        super(source);
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }

    public abstract void ejecutar(NotificationService notificationService);
}
