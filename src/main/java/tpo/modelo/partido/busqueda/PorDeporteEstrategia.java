package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;

public class PorDeporteEstrategia implements EstrategiaDeSelecionDePartidos {

    private String deporte;

    public PorDeporteEstrategia(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getDeporte().equalsIgnoreCase(deporte);
    }
}
