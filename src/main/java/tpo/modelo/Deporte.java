package tpo.modelo;

public class Deporte {
    private String nombre;
    private int jugadoresMin;
    
    
    
    public Deporte(String nombre, int jugadoresMin) {
        this.nombre = nombre;
        this.jugadoresMin = jugadoresMin;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getJugadoresMin() {
        return jugadoresMin;
    }
    public void setJugadoresMin(int jugadoresMin) {
        this.jugadoresMin = jugadoresMin;
    }
}
