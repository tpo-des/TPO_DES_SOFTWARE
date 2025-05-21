package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;

public class PartidosNoFinalizadosEstrategia implements EstrategiaDeSelecionDePartidos {

    @Override
    public boolean esCumplidaPor(Partido partido) {
        EstrategiaDeSelecionDePartidos estrategiaOpuesta = new PartidosFinalizadosEstrategia();
        return !estrategiaOpuesta.esCumplidaPor(partido);
    }
}
