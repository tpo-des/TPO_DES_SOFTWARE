package Controlador;
import Modelo.RepositorioUsuarios;
import Modelo.Usuario;
import Modelo.Usuario.Nivel;

public class ControladorUsuario {
    private RepositorioUsuarios repo;

    public ControladorUsuario(RepositorioUsuarios repo) {
        this.repo = repo;
    }

    public boolean registrarUsuario(String nombre, String correo, String pass, String deporte, Usuario.Nivel nivel) {
        Usuario nuevo = new Usuario(nombre, correo, pass, deporte, nivel);
        return repo.registrar(nuevo);
    }

    public Usuario login(String correo, String contraseña) {
        return repo.iniciarSesion(correo, contraseña);
    }
}

