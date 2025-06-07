package tpo;

import tpo.controlador.ControladorPartido;
import tpo.controlador.ControladorUsuario;
import tpo.modelo.RepositorioPartidos;
import tpo.modelo.RepositorioUsuarios;
import tpo.modelo.Usuario;
import tpo.vista.VistaPartido;
import tpo.vista.VistaUsuario;

import java.util.Scanner;

public class Main {

    /*public static void main(String[] args) {
        // Repositorios
        RepositorioUsuarios repoUsuarios = new RepositorioUsuarios();
        RepositorioPartidos repoPartidos = new RepositorioPartidos();

        // Controladores
        ControladorUsuario controladorUsuario = new ControladorUsuario(repoUsuarios);
        ControladorPartido controladorPartido = new ControladorPartido(repoPartidos);

        // Vistas
        VistaUsuario vistaUsuario = new VistaUsuario(controladorUsuario);
        VistaPartido vistaPartido = new VistaPartido(controladorPartido);

        // Estado de sesión
        Usuario usuarioActual = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ ---");

            if (usuarioActual == null) {
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Buscar partidos sin cuenta");
                System.out.println("4. Salir");

                String opcion = sc.nextLine();

                switch (opcion) {
                    case "1" -> vistaUsuario.registrar();
                    case "2" -> {
                        usuarioActual = vistaUsuario.login();
                        if (usuarioActual != null) {
                            System.out.println("✔ Sesión iniciada como: " + usuarioActual.getNombreUsuario());
                        }
                    }
                    case "3" -> vistaPartido.buscarPartidos();
                    case "4" -> {
                        System.out.println("Hasta luego!");
                        return;
                    }
                    default -> System.out.println("❌ Opción inválida");
                }

            } else {
                System.out.println("\n✔ Sesión: " + usuarioActual.getNombreUsuario());
                System.out.println("1. Crear partido");
                System.out.println("2. Buscar partidos");
                System.out.println("3. Unirse a un partido");
                System.out.println("4. Confirmar participación");
                System.out.println("5. Cerrar sesión");
                System.out.println("6. Ver historial de partidos finalizados");

                String opcion = sc.nextLine();

                switch (opcion) {
                    case "1" -> vistaPartido.crearPartido();
                    case "2" -> vistaPartido.buscarPartidos();
                    case "3" -> vistaPartido.unirseAPartido(usuarioActual);
                    case "4" -> vistaPartido.confirmarPartido(usuarioActual);
                    case "5" -> {
                        System.out.println("Sesión cerrada.");
                        usuarioActual = null;
                    }
                    case "6" -> vistaPartido.mostrarHistorialPartidos();
                    default -> System.out.println("❌ Opción inválida");
                }
            }
        }
    }*/
}
