package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class Finalizado implements EstadoPartido {
    @Override
    public String getNombre() {
        return "Finalizado";
    }

    @Override
    public String agregarJugador(Partido partido, Usuario jugador) {
        return "El partido ya esta finalizado no podemos agregar más jugadores!";
    }
}
