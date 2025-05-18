package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;
import tpo.modelo.estados.NecesitamosJugadores;

public class PartidosNecesitadosDeJugadoresEstrategia implements EstrategiaDeSelecionDePartidos {

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getEstado() instanceof NecesitamosJugadores;
    }
}
