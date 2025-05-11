package Modelo;

import java.util.List;

public interface Strategy {
    
    List<Usuario> filtrar(List<Usuario> candidatos, Partido partido);
}
