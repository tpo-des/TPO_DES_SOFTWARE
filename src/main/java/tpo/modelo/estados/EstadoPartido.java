package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public interface EstadoPartido {

    String getNombre();
    /*
    Cuando un partido alcance el número requerido de jugadores, pasará automáticamente al
    estado "Partido armado".
     */
    String agregarJugador(Partido partido, Usuario jugador);
}