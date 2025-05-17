package tpo.controlador;
import tpo.modelo.RepositorioUsuarios;
import tpo.modelo.Usuario;

public class ControladorUsuario {
    private RepositorioUsuarios repo;

    public ControladorUsuario(RepositorioUsuarios repo) {
        this.repo = repo;
    }


    public boolean registrarUsuario(String nombre, String correo, String pass,
                                    String deporte, Usuario.Nivel nivel, String localidad) {
        Usuario nuevo = new Usuario(nombre, correo, pass, deporte, nivel, localidad);
        return repo.registrar(nuevo);
    }

    public Usuario login(String correo, String contraseña) {
        return repo.iniciarSesion(correo, contraseña);
    }
}

