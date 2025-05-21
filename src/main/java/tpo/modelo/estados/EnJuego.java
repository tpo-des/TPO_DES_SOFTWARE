package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class EnJuego implements EstadoPartido {

    @Override
    public String getNombre() {
        return "En juego";
    }

    @Override
    public String agregarJugador(Partido partido, Usuario jugador) {
        return "El partido ya se esta jugando no podemos agregar más jugadores!";
    }
}
