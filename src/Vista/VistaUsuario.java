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

    public void mostrarMenu() {
        System.out.println("1. Registrarse\n2. Iniciar sesión");
        String opcion = sc.nextLine();
        if (opcion.equals("1")) registrar();
        else if (opcion.equals("2")) login();
    }

    private void registrar() {
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Correo:");
        String correo = sc.nextLine();
        System.out.println("Contraseña:");
        String pass = sc.nextLine();
        System.out.println("Deporte favorito:");
        String deporte = sc.nextLine();
        System.out.println("Nivel (PRINCIPIANTE/INTERMEDIO/AVANZADO):");
        Usuario.Nivel nivel = Usuario.Nivel.valueOf(sc.nextLine().toUpperCase());

        boolean ok = controlador.registrarUsuario(nombre, correo, pass, deporte, nivel);
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
