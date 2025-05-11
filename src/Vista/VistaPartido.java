package Vista;

import Controlador.ControladorPartido;
import Modelo.Partido;
import Modelo.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class VistaPartido {
    private ControladorPartido controlador;
    private Scanner sc = new Scanner(System.in);

    public VistaPartido(ControladorPartido controlador) {
        this.controlador = controlador;
    }

    public void crearPartido() {
        try {
            System.out.println("Crear nuevo partido");

            System.out.print("Deporte: ");
            String deporte = sc.nextLine();

            System.out.print("Cantidad de jugadores: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            System.out.print("Ubicación: ");
            String ubicacion = sc.nextLine();

            System.out.print("Fecha (AAAA/MM/DD): ");
            String fecha = sc.nextLine();
            System.out.print("Hora (HH:MM): ");
            String hora = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime fechaHora = LocalDateTime.parse(fecha + " " + hora, formatter);

            controlador.crearPartido(deporte, cantidad, ubicacion, fechaHora);
            System.out.println("✅ Partido creado con éxito.");
        } catch (DateTimeParseException e) {
            System.out.println("❌ Formato de fecha/hora inválido.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void buscarPartidos() {
        System.out.print("Buscar partidos por deporte: ");
        String deporte = sc.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();

        List<Partido> resultados = controlador.buscarPartidos(deporte, ubicacion);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron partidos disponibles.");
        } else {
            System.out.println("Partidos encontrados:");
            for (Partido p : resultados) {
                System.out.println(p);
            }
        }
    }

    public void unirseAPartido(Usuario usuario) {
        List<Partido> disponibles = controlador.BuscarPartidosAbiertos();

        if (disponibles.isEmpty()) {
            System.out.println("No hay partidos disponibles para unirse.");
            return;
        }

        System.out.println("Partidos disponibles:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i));
        }

        System.out.print("Seleccioná el número del partido al que querés unirte: ");
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion < 1 || opcion > disponibles.size()) {
                System.out.println("Número inválido.");
                return;
            }
            Partido elegido = disponibles.get(opcion - 1);
            elegido.agregarJugador(usuario);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void confirmarPartido(Usuario usuario) {
        List<Partido> pendientes = controlador.partidosParaConfirmarDe(usuario);
        if (pendientes.isEmpty()) {
            System.out.println("No tenés partidos para confirmar.");
            return;
        }

        System.out.println("Partidos por confirmar:");
        for (int i = 0; i < pendientes.size(); i++) {
            System.out.println((i + 1) + ". " + pendientes.get(i));
        }

        System.out.print("Seleccioná el número del partido a confirmar: ");
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion < 1 || opcion > pendientes.size()) {
                System.out.println("Número inválido.");
                return;
            }
            Partido elegido = pendientes.get(opcion - 1);
            elegido.confirmarParticipacion(usuario);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }
}
