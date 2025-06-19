package tpo.modelo;

import java.util.Observer;

public class Observable{
    List<Observador> observadores = new ArrayList<>(); 
    
    
    void agregarObservador(Observer o)
    {
        observadores.add(o);
    }

    void eliminarObservador(Observer o){
        observadores.remove(o);
    }
    
    void notificarObservador(){
        for(Observador o : observadores) {
            o.actualizar(this);
        }
    };
}
