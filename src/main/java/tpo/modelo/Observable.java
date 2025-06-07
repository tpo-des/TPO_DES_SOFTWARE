package tpo.modelo;

import java.util.Observer;

public interface Observable{
    void agregarObservador(Observer o);
    void eliminarObservador(Observer o);
    void notificarObservador(Observer o);
}
