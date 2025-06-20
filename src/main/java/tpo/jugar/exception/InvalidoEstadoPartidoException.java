package tpo.jugar.exception;

import tpo.jugar.model.partido.Partido;

public class InvalidoEstadoPartidoException extends IllegalStateException {

    public InvalidoEstadoPartidoException(Partido partido) {
        super("El partido con id " + partido.getId() + " tiene el estado " + partido.getEstado() + "  que es invalido para esta operacion." );
    }
}
