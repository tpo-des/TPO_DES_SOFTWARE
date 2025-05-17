package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Estados.Finalizado;
import Modelo.Estados.NecesitamosJugadores;
import Modelo.Estados.PartidoArmado;

public class RepositorioPartidos {
    private List<Partido> partidos = new ArrayList<>();

    public void agregar(Partido p) {
        partidos.add(p);
    }

    public List<Partido> buscar(String deporte, String ubicacion) {
        return partidos.stream()
            .filter(p -> p.getEstado() instanceof NecesitamosJugadores)
            .filter(p -> p.getDeporte().equalsIgnoreCase(deporte))
            .filter(p -> p.getUbicacion().equalsIgnoreCase(ubicacion))
            .collect(Collectors.toList());
    }

    public List<Partido> obtenerTodos() {
        return partidos;
    }
    public List<Partido> partidosParaConfirmarDe(Usuario usuario) {
    return partidos.stream()
        .filter(p -> p.getEstado() instanceof PartidoArmado)
        .filter(p -> p.getJugadores().contains(usuario))
        .collect(Collectors.toList());
}

    public List<Partido> obtenerPartidosFinalizados() {
        return partidos.stream()
                .filter(p -> p.getEstado() instanceof Finalizado)
                .collect(Collectors.toList());
    }



    public List<Partido> buscarPartidosNoFinalizados(String deporte, String ubicacion) {
        return partidos.stream()
                .filter(p -> ! (p.getEstado() instanceof Finalizado)) // excluye finalizados
                .filter(p -> p.getDeporte().equalsIgnoreCase(deporte))
                .filter(p -> p.getUbicacion().equalsIgnoreCase(ubicacion))
                .collect(Collectors.toList());
    }

    
    public List<Partido> buscarAbiertos() {
        return partidos.stream()
            .filter(p -> p.getEstado() instanceof NecesitamosJugadores)
            .collect(Collectors.toList());
    }
    
}
