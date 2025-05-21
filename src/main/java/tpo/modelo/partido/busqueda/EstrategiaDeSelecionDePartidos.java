package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;

// Estrategia del patron
public interface EstrategiaDeSelecionDePartidos {

    boolean esCumplidaPor(Partido partido);
}
