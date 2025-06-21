package tpo.jugar.model.notification;

public class EstrategiaDeNotificacionFactory {

    public static EstrategiaDeNotificacion create(TipoEstrategiaNotificacion tipo) {
        return switch (tipo) {
            case EMAIL -> new PorEmailEstrategiaDeNotificacion();
            case SMS -> new PorSMSEstrategiaDeNotificacion(new FireBaseSmsServiceAdapter(new FireBaseService()));
        };
    }
}
