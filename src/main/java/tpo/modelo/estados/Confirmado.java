package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class Confirmado implements EstadoPartido {

    @Override
    public String getNombre() {
        return "Confirmado";
    }

    @Override
    public String agregarJugador(Partido partido, Usuario jugador) {
        return "El partido ya esta confirmado no podemos agregar más jugadores!";
    }
}
