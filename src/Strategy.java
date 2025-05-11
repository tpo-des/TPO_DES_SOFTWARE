import java.util.List;

import Modelo.Partido;
import Modelo.Usuario;

public interface Strategy {
    
    List<Usuario> filtrar(List<Usuario> candidatos, Partido partido);
}
