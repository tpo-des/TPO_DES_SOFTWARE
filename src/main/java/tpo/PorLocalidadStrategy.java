package tpo;

import java.util.List;
import java.util.stream.Collectors;

import tpo.modelo.Strategy;
import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class PorLocalidadStrategy implements Strategy {

    @Override
    public List<Usuario> filtrar(List<Usuario> candidatos, Partido partido) {
        String localidadPartido = partido.getUbicacion(); // asumimos que esto es la localidad

        return candidatos.stream()
                .filter(u -> u.getLocalidad().equalsIgnoreCase(localidadPartido))
                .collect(Collectors.toList());
    }
}
