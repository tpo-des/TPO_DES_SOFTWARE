package tpo.vista;

import tpo.controlador.ControladorPartido;
import tpo.modelo.Partido;
import tpo.modelo.Usuario;

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

            System.out.print("Duración (horas): ");
            int duracion = Integer.parseInt(sc.nextLine());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime fechaHora = LocalDateTime.parse(fecha + " " + hora, formatter);

            controlador.crearPartido(deporte, cantidad, ubicacion, fechaHora, duracion);
            System.out.println("✅ Partido creado con éxito.");
        } catch (DateTimeParseException e) {
            System.out.println("❌ Formato de fecha/hora inválido.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Duración inválida. Ingresá un número entero.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void mostrarHistorialPartidos() {
        List<Partido> finalizados = controlador.obtenerPartidosFinalizados();
        if (finalizados.isEmpty()) {
            System.out.println("No hay partidos finalizados aún.");
            return;
        }

        System.out.println("Historial de partidos finalizados:");
        for (int i = 0; i < finalizados.size(); i++) {
            System.out.println((i + 1) + ". " + finalizados.get(i));
        }

        System.out.print("Elegí un partido para agregar comentarios o estadísticas (0 para salir): ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > finalizados.size()) {
            System.out.println("Salida del historial.");
            return;
        }


        Partido seleccionado = finalizados.get(opcion - 1);

        System.out.println("1. Agregar comentario");
        System.out.println("2. Agregar estadística");
        System.out.println("3. Volver");
        int eleccion = Integer.parseInt(sc.nextLine());

        switch (eleccion) {
            case 1 -> {
                System.out.print("Escribí el comentario: ");
                String comentario = sc.nextLine();
                seleccionado.agregarComentario(comentario);
                System.out.println("Comentario agregado.");
            }
            case 2 -> {
                System.out.print("Nombre de la estadística (ej: goles): ");
                String clave = sc.nextLine();
                System.out.print("Valor numérico: ");
                int valor = Integer.parseInt(sc.nextLine());
                seleccionado.agregarEstadistica(clave, valor);
                System.out.println("Estadística agregada.");
            }
            case 3 -> System.out.println("Volviendo al menú principal.");
            default -> System.out.println("Opción inválida.");
        }
    }



    public void buscarPartidos() {
        System.out.print("Buscar partidos por deporte: ");
        String deporte = sc.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();

        List<Partido> resultados = controlador.buscarPartidosNoFinalizados(deporte, ubicacion);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron partidos disponibles.");
        } else {
            System.out.println("Partidos encontrados:");
            for (Partido p : resultados) {
                p.transicionar(); // actualiza estado antes de mostrar
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
            String resultado = elegido.agregarJugador(usuario);
            System.out.println(resultado);
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
