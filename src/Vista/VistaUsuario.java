package Vista;
import java.util.Scanner;

import Controlador.ControladorUsuario;
import Modelo.Usuario;

public class VistaUsuario {
    private ControladorUsuario controlador;
    private Scanner sc = new Scanner(System.in);

    public VistaUsuario(ControladorUsuario controlador) {
        this.controlador = controlador;
    }

    public void registrar() {
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Correo:");
        String correo = sc.nextLine();
        System.out.println("Contraseña:");
        String pass = sc.nextLine();
        System.out.println("Deporte favorito (opcional):");
        String deporte = sc.nextLine();
        if (deporte.isBlank()) deporte = null;

        System.out.println("Nivel (PRINCIPIANTE/INTERMEDIO/AVANZADO) (opcional):");
        String nivelTexto = sc.nextLine();
        Usuario.Nivel nivel = null;
        if (!nivelTexto.isBlank()) {
            try {
                nivel = Usuario.Nivel.valueOf(nivelTexto.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Nivel inválido, se dejará vacío.");
            }
        }

        System.out.println("Localidad:");
        String localidad = sc.nextLine();

        boolean ok = controlador.registrarUsuario(nombre, correo, pass, deporte, nivel, localidad);
        System.out.println(ok ? "Registro exitoso" : "Correo ya registrado");
    }



    public Usuario login() {
        System.out.println("Correo:");
        String correo = sc.nextLine();
        System.out.println("Contraseña:");
        String pass = sc.nextLine();
        Usuario u = controlador.login(correo, pass);
        if (u != null) {
            System.out.println("Bienvenido " + u.getNombreUsuario());
        } else {
            System.out.println("Credenciales inválidas.");
        }
        return u;
    }
    
    

}
