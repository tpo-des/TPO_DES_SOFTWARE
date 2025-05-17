package tpo.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tpo.modelo.estados.*;

public class Partido {
    private String deporte;
    private int cantidadJugadores;
    private String ubicacion;
    private LocalDateTime horario;
    private List<Usuario> jugadores;
    private EstadoPartido estado;
    private List<Usuario> jugadoresConfirmados = new ArrayList<>();
    private Strategy estrategiaEmparejamiento = new PorLocalidadStrategy(); // por defecto
    private int duracion; // en horas

    private String comentarios = "";
    private Map<String, Integer> estadisticas = new HashMap<>();


    public Partido(String deporte, int cantidadJugadores, String ubicacion, LocalDateTime horario,  int duracion) {
        this.deporte = deporte;
        this.cantidadJugadores = cantidadJugadores;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.jugadores = new ArrayList<>();
        this.estado = new NecesitamosJugadores(); // Estado inicial
        this.jugadoresConfirmados = new ArrayList<>();
        this.duracion = duracion;

    }

    public void agregarComentario(String comentario) {
        if (!comentarios.isEmpty()) {
            comentarios += "\n";
        }
        comentarios += comentario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void agregarEstadistica(String clave, int valor) {
        estadisticas.put(clave, valor);
    }

    public Map<String, Integer> getEstadisticas() {
        return estadisticas;
    }



    public void setEstrategiaEmparejamiento(Strategy estrategia) {
        this.estrategiaEmparejamiento = estrategia;
    }
    

    public List<Usuario> emparejarCandidatos(List<Usuario> candidatos) {
        return estrategiaEmparejamiento.filtrar(candidatos, this);
    }
    

    public void confirmarParticipacion(Usuario usuario) {
    if (!(estado instanceof PartidoArmado)) {
        System.out.println("⚠ No se puede confirmar este partido. Estado actual: " + estado.getNombre());
        return;
    }

    if (!jugadores.contains(usuario)) {
        System.out.println("❌ No estás inscripto en este partido.");
        return;
    }

    if (jugadoresConfirmados.contains(usuario)) {
        System.out.println("Ya habías confirmado.");
        return;
    }

    jugadoresConfirmados.add(usuario);
    System.out.println("✔ Confirmaste tu participación.");

    if (jugadoresConfirmados.size() == jugadores.size()) {
        setEstado(new Confirmado());
        System.out.println("🎉 Todos confirmaron. El partido está CONFIRMADO.");
    }
}



    public String agregarJugador(Usuario usuario) {
        return estado.agregarJugador(this, usuario);
    }

    public void transicionar() {
        LocalDateTime ahora = LocalDateTime.now();

        if (estado instanceof NecesitamosJugadores && jugadores.size() == cantidadJugadores) {
            setEstado(new PartidoArmado());
            System.out.println("✔ El partido cambió de estado a: " + estado.getNombre());
        }
        else if (estado instanceof PartidoArmado) {
            // Podrías agregar lógica para pasar a Confirmado si todos confirman
            // Por ahora no implementado
        }
        else if (estado instanceof Confirmado) {
            if (ahora.isAfter(horario) && ahora.isBefore(horario.plusHours(duracion))) {
                setEstado(new EnJuego());
                System.out.println("▶ El partido comenzó y está en juego.");
            } else if (ahora.isAfter(horario.plusHours(duracion))) {
                setEstado(new Finalizado());
                System.out.println("✔ El partido ha finalizado.");
            }
        }
        else if (estado instanceof EnJuego) {
            if (ahora.isAfter(horario.plusHours(duracion))) {
                setEstado(new Finalizado());
                System.out.println("✔ El partido ha finalizado.");
            }
        }
    }

    public void setEstado(EstadoPartido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public EstadoPartido getEstado() {
        return estado;
    }

    public String getDeporte() { return deporte; }

    public String getUbicacion() { return ubicacion; }

    public int getFaltantes() {
        return cantidadJugadores - jugadores.size();
    }

    @Override
    public String toString() {
        return deporte + " en " + ubicacion + " - Duración: " + duracion + " hs - Estado: " + estado.getNombre() + " - Faltan: " + getFaltantes();
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Usuario> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Usuario> getJugadoresConfirmados() {
        return jugadoresConfirmados;
    }

    public void setJugadoresConfirmados(List<Usuario> jugadoresConfirmados) {
        this.jugadoresConfirmados = jugadoresConfirmados;
    }
}
