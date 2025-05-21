package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class PorMismoOMenorNivelDejuegoEstrategia  implements EstrategiaDeSelecionDePartidos {


    private Usuario.Nivel nivel;

    public PorMismoOMenorNivelDejuegoEstrategia(Usuario.Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getNivelMinimoRequerido().compareTo(nivel) <= 0;
    }
}
