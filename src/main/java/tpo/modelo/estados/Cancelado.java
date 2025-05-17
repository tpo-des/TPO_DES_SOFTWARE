package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class Cancelado implements EstadoPartido {
    @Override
    public String getNombre() {
        return "Cancelado";
    }

    @Override
    public String agregarJugador(Partido partido, Usuario jugador) {
        return "El doparti esta cancelado papa, que queres hacer!!!";
    }
}
