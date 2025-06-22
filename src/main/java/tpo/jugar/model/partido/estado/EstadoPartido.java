package tpo.jugar.model.partido.estado;

import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;

public interface EstadoPartido {
    String agregarJugador(ContextoEstadoPartido contexto, Jugador jugador);
    String finalizar(ContextoEstadoPartido contexto);
    String cancelar(ContextoEstadoPartido contexto);
    String comenzar(ContextoEstadoPartido contexto);
    String confirmar(ContextoEstadoPartido contexto, Jugador jugador);
}
