package tpo.jugar.model.notification;

public class FireBaseSmsServiceAdapter implements  SMSServiceAdapter {

    FireBaseService firebaseService;

    public FireBaseSmsServiceAdapter(FireBaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @Override
    public void enviarMensajeDeTexto(int numero, String mensaje) {
        firebaseService.sendPush(Integer.toString(numero), mensaje);
    }
}
