package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class PorMismoNivelDeJuegoEstrategia implements EstrategiaDeSelecionDePartidos {

    private Usuario.Nivel nivelRequerido;

    public PorMismoNivelDeJuegoEstrategia(Usuario.Nivel nivel) {
        this.nivelRequerido = nivel;
    }

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getNivelMinimoRequerido().equals(nivelRequerido);
    }
}
