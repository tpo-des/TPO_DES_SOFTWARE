package tpo.jugar.model.partido.estado;

import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.Usuario;

public interface EstadoPartido {
    String agregarJugador(ContextoEstadoPartido contexto, Usuario usuario);
    String finalizar(ContextoEstadoPartido contexto);
    String cancelar(ContextoEstadoPartido contexto);
    String comenzar(ContextoEstadoPartido contexto);
}
