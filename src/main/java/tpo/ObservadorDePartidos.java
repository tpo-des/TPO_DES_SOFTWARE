public class ObservadorDePartidos implements Observador{

    private List<Partido> partidosObservados = new ArrayList<>();

    public void serNotificadoPor(Observable o){
        partidosObservados.find()
        for(Partido partido: partidosObservados){
            if(o.equals(partido)){
                alert("mandar mensaje")
            }
        }
    }
    public void observarPartido(Partido partido){
        partidosObservados.add(partido);
        partido.agregarObservador(this);
    }
    public void desObservarPartido(Partido partido){
        partidosObservados.remove(partido);
        partido.eliminarObservador(this);
    }

}