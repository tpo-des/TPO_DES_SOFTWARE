package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;

public class PorLocalidadDelPartidoEstrategia implements EstrategiaDeSelecionDePartidos {

    private String localidad;

    public PorLocalidadDelPartidoEstrategia(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getUbicacion().equalsIgnoreCase(localidad);
    }
}
