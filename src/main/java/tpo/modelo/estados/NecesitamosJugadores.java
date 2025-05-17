package tpo.modelo.estados;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class NecesitamosJugadores implements EstadoPartido {

    @Override
    public String getNombre() {
        return "Necesitamos jugadores";
    }


    @Override
    public String agregarJugador(Partido partido, Usuario jugador) {
        partido.getJugadores().add(jugador);
        if (partido.getFaltantes() == 0) {
            partido.setEstado(new PartidoArmado());
            return "El partido esta Armado!!";
        }
        return "Faltan " + partido.getFaltantes() + " Jugadores para Armar el Doparti!!";
    }
}
