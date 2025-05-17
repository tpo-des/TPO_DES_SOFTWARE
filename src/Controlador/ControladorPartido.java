package Controlador;
import java.time.LocalDateTime;
import java.util.List;

import Modelo.Partido;
import Modelo.RepositorioPartidos;
import Modelo.Usuario;

public class ControladorPartido {
    private RepositorioPartidos repo;




    public ControladorPartido(RepositorioPartidos repo) {
        this.repo = repo;
    }

    public List<Partido> obtenerPartidosFinalizados() {
        return repo.obtenerPartidosFinalizados();
    }


    public List<Partido> buscarPartidos(String deporte, String ubicacion) {
        return repo.buscar(deporte, ubicacion);
    }

    public void crearPartido(String deporte, int cantidad, String ubicacion, LocalDateTime fechaHora, int duracion) {
        Partido nuevo = new Partido(deporte, cantidad, ubicacion, fechaHora, duracion);
        repo.agregar(nuevo);
    }


    public List<Partido> BuscarPartidosAbiertos() {
        return repo.buscarAbiertos(); // necesita nuevo método en el repositorio
    }

    public List<Partido> buscarPartidosNoFinalizados(String deporte, String ubicacion) {
        return repo.buscarPartidosNoFinalizados(deporte, ubicacion);
    }


    public List<Partido> partidosParaConfirmarDe(Usuario usuario) {
    return repo.partidosParaConfirmarDe(usuario);
}

// public void confirmarPartido(Usuario usuario) {
//     List<Partido> pendientes = controlador.partidosParaConfirmarDe(usuario);
//     if (pendientes.isEmpty()) {
//         System.out.println("No tenés partidos para confirmar.");
//         return;
//     }

//     System.out.println("Partidos por confirmar:");
//     for (int i = 0; i < pendientes.size(); i++) {
//         System.out.println((i + 1) + ". " + pendientes.get(i));
//     }

//     System.out.print("Seleccioná el número del partido a confirmar: ");
//     try {
//         int opcion = Integer.parseInt(sc.nextLine());
//         if (opcion < 1 || opcion > pendientes.size()) {
//             System.out.println("Número inválido.");
//             return;
//         }
//         Partido elegido = pendientes.get(opcion - 1);
//         elegido.confirmarParticipacion(usuario);
//     } catch (NumberFormatException e) {
//         System.out.println("Entrada inválida.");
//     }
// }


}
