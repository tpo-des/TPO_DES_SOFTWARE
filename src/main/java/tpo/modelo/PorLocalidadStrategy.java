package tpo.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class PorLocalidadStrategy implements Strategy {

    @Override
    public List<Usuario> filtrar(List<Usuario> candidatos, Partido partido) {
        String localidadPartido = partido.getUbicacion(); // asumimos que la ubicación es la localidad

        return candidatos.stream()
                .filter(u -> u.getLocalidad().equalsIgnoreCase(localidadPartido))
                .collect(Collectors.toList());
    }
}
