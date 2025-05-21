package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;

import java.util.List;
import java.util.stream.Collectors;

// Contexto de patron estrategia
public class BuscadorDePartidos {

    private EstrategiaDeSelecionDePartidos estrategiaDeSelecionDePartidos = null;
    private List<Partido> partidos;

    public BuscadorDePartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public List<Partido> buscar() {
        return partidos
                .stream()
                .filter(partido -> estrategiaDeSelecionDePartidos.esCumplidaPor(partido))
                .collect(Collectors.toList());
    }

    public void setEstrategia(EstrategiaDeSelecionDePartidos estrategia) {
        this.estrategiaDeSelecionDePartidos = estrategia;
    }
}
