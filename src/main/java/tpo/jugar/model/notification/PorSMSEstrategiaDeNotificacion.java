package tpo.jugar.model.notification;


import tpo.jugar.model.usuario.Usuario;

public class PorSMSEstrategiaDeNotificacion implements EstrategiaDeNotificacion {


    private final SMSServiceAdapter smsServiceAdapter;

    public PorSMSEstrategiaDeNotificacion(SMSServiceAdapter smsServiceAdapter) {
        this.smsServiceAdapter = smsServiceAdapter;
    }

    @Override
    public void notificar(Usuario usuario, String mensaje){
        smsServiceAdapter.enviarMensajeDeTexto(1141, mensaje);
    };
}
