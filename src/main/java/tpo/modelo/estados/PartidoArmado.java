package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class PartidoArmado implements EstadoPartido {

    @Override
    public String getNombre() {
        return "Partido armado";
    }

    @Override
    public String agregarJugador(Partido partido, Usuario jugador) {
        return "El partido ya esta armado no podemos agregar más jugadores!";
    }
}
