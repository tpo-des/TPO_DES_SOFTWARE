package tpo.controlador;
import java.util.List;

import tpo.modelo.Deporte;
import tpo.modelo.RepositorioUsuarios;
import tpo.modelo.Usuario;

public class ControladorUsuario {
    private RepositorioUsuarios repo;

    public ControladorUsuario(RepositorioUsuarios repo) {
        this.repo = repo;
    }


    public boolean registrarUsuario(String nombre, String correo, String pass,
                                    String deporte, Usuario.Nivel nivel, String localidad, List<Deporte> deportes) {
        Usuario nuevo = new Usuario(nombre, correo, pass, deporte, nivel, localidad, deportes);
        return repo.registrar(nuevo);
    }

    public Usuario login(String correo, String contraseña) {
        return repo.iniciarSesion(correo, contraseña);
    }
}

