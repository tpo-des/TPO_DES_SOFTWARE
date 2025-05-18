package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;

import java.util.List;

public class PorMultiplesEstrategias implements EstrategiaDeSelecionDePartidos {

    private List<EstrategiaDeSelecionDePartidos> estrategias;

    public PorMultiplesEstrategias(List<EstrategiaDeSelecionDePartidos> estrategias) {
        this.estrategias = estrategias;
    }

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return estrategias
                .stream()
                .allMatch(estrategia -> estrategia.esCumplidaPor(partido));

    }
}
