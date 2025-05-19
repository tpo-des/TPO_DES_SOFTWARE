package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;
import tpo.modelo.estados.Finalizado;

public class PartidosFinalizadosEstrategia  implements  EstrategiaDeSelecionDePartidos {

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getEstado() instanceof Finalizado;
    }
}
