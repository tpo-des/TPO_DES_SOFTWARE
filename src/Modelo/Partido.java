package Modelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Modelo.Estados.Confirmado;
import Modelo.Estados.EstadoPartido;
import Modelo.Estados.NecesitamosJugadores;
import Modelo.Estados.PartidoArmado;
import Strategy;

public class Partido {
    private String deporte;
    private int cantidadJugadores;
    private String ubicacion;
    private LocalDateTime horario;
    private List<Usuario> jugadores;
    private EstadoPartido estado;
    private List<Usuario> jugadoresConfirmados = new ArrayList<>();
    private Strategy estrategiaEmparejamiento = new PorLocalidadStrategy(); // por defecto




    public Partido(String deporte, int cantidadJugadores, String ubicacion, LocalDateTime horario) {
        this.deporte = deporte;
        this.cantidadJugadores = cantidadJugadores;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.jugadores = new ArrayList<>();
        this.estado = new NecesitamosJugadores(); // Estado inicial
        this.jugadoresConfirmados = new ArrayList<>();
        
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



    public void agregarJugador(Usuario u) {
        if (jugadores.size() < cantidadJugadores) {
            jugadores.add(u);
            System.out.println("Jugador agregado: " + u.getNombreUsuario());
            if (jugadores.size() == cantidadJugadores) {
                transicionar();
            }
        } else {
            System.out.println("El partido ya está completo.");
        }
    }

    // Transición automática de estado
    public void transicionar() {
        if (estado instanceof NecesitamosJugadores && jugadores.size() == cantidadJugadores) {
            setEstado(new PartidoArmado());
            System.out.println("✔ El partido cambió de estado a: " + estado.getNombre());
        }

        // En una versión futura podés seguir con más:
        // if (estado instanceof PartidoArmado && ... ) setEstado(new Confirmado());
        // if (LocalDateTime.now().isAfter(horario)) setEstado(new EnJuego());
    }

    private void setEstado(EstadoPartido nuevoEstado) {
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
        return deporte + " en " + ubicacion + " - Estado: " + estado.getNombre() + " - Faltan: " + getFaltantes();
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
