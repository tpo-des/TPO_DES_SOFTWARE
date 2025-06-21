package tpo.jugar.model.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireBaseService {

    private final Logger logger = LoggerFactory.getLogger(PorSMSEstrategiaDeNotificacion.class);

    public void sendPush(String token, String msg){
        logger.info("Enviando mensaje token: {} msg: {}", token, msg);
    }
}
