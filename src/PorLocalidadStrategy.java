import java.util.List;
import java.util.stream.Collectors;

import Partido;
import Usuario;

public class PorLocalidadStrategy implements Strategy {

    @Override
    public List<Usuario> filtrar(List<Usuario> candidatos, Partido partido) {
        String localidadPartido = partido.getUbicacion(); // asumimos que esto es la localidad

        return candidatos.stream()
                .filter(u -> u.getLocalidad().equalsIgnoreCase(localidadPartido))
                .collect(Collectors.toList());
    }
}
