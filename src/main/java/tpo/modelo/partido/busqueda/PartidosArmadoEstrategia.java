package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;
import tpo.modelo.estados.PartidoArmado;

public class PartidosArmadoEstrategia implements  EstrategiaDeSelecionDePartidos {

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getEstado() instanceof PartidoArmado;
    }
}
