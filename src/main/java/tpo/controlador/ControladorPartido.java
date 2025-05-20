package tpo.controlador;
import java.time.LocalDateTime;
import java.util.List;

import tpo.modelo.Partido;
import tpo.modelo.RepositorioPartidos;
import tpo.modelo.Usuario;
import tpo.modelo.partido.busqueda.*;

public class ControladorPartido {

    private RepositorioPartidos repo;
    private BuscadorDePartidos buscadorDePartidos;

    public ControladorPartido(RepositorioPartidos repo) {
        this.repo = repo;
        this.buscadorDePartidos = new BuscadorDePartidos(repo.getPartidos());
    }

    private List<Partido> buscarPor(EstrategiaDeSelecionDePartidos estrategia) {
        buscadorDePartidos.setEstrategia(estrategia);
        return buscadorDePartidos.buscar();
    }

    public List<Partido> obtenerPartidosFinalizados() {
        return buscarPor(new PartidosFinalizadosEstrategia());
    }

    public List<Partido> buscarPartidos(String deporte, String ubicacion) {
        List<EstrategiaDeSelecionDePartidos> estrategias = List.of(
                new PorDeporteEstrategia(deporte),
                new PorLocalidadDelPartidoEstrategia(ubicacion),
                new PartidosNecesitamosDeJugadoresEstrategia()
        );
        return buscarPor(new PorMultiplesEstrategias(estrategias));
    }

    public void crearPartido(String deporte, int cantidad, String ubicacion, LocalDateTime fechaHora, int duracion) {
        Partido nuevo = new Partido(deporte, cantidad, ubicacion, fechaHora, duracion);
        repo.agregar(nuevo);
    }


    public List<Partido> BuscarPartidosAbiertos() {
        return buscarPor(new PartidosNecesitamosDeJugadoresEstrategia());
    }

    public List<Partido> buscarPartidosNoFinalizados(String deporte, String ubicacion) {
        List<EstrategiaDeSelecionDePartidos> estrategias = List.of(
                new PorDeporteEstrategia(deporte),
                new PorLocalidadDelPartidoEstrategia(ubicacion),
                new PartidosNoFinalizadosEstrategia()
        );
        return buscarPor(new PorMultiplesEstrategias(estrategias));
    }

    public List<Partido> partidosParaConfirmarDe(Usuario usuario) {
        List<EstrategiaDeSelecionDePartidos> estrategias = List.of(
                new PartidosArmadoEstrategia(),
                new UsuarioJuegaEnElPartidoEstrategia(usuario)
        );
        return buscarPor(new PorMultiplesEstrategias(estrategias));
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
