package tpo.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tpo.modelo.estados.Finalizado;
import tpo.modelo.estados.NecesitamosJugadores;
import tpo.modelo.estados.PartidoArmado;

public class RepositorioPartidos {

    private List<Partido> partidos = new ArrayList<>();
    private static RepositorioPartidos instancia;

    public static RepositorioPartidos getInstance() {
        if (instancia == null) {
            instancia = new RepositorioPartidos();
        }
        return instancia;
    }
    private RepositorioPartidos() {} // constructor privado

    public void agregar(Partido p) {
        partidos.add(p);
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Partido> partidosParaConfirmarDe(Usuario usuario) {
    return partidos.stream()
        .filter(p -> p.getEstado() instanceof PartidoArmado)
        .filter(p -> p.getJugadores().contains(usuario))
        .collect(Collectors.toList());
    }

    public List<Partido> buscarPorDeporteYUbicacion(String deporte, String ubicacion) {
        return partidos.stream()
                .filter(p -> p.getDeporte().equalsIgnoreCase(deporte))
                .filter(p -> p.getUbicacion().equalsIgnoreCase(ubicacion))
                .filter(p -> !(p.getEstado() instanceof Finalizado)) // filtra partidos activos
                .collect(Collectors.toList());
    }





}
