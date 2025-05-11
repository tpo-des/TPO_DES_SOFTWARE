package Modelo;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();

    public boolean registrar(Usuario u) {
        for (Usuario existente : usuarios) {
            if (existente.getCorreo().equals(u.getCorreo())) return false; // ya existe
        }
        usuarios.add(u);
        return true;
    }

    public Usuario iniciarSesion(String correo, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.verificarCredenciales(correo, contraseña)) return u;
        }
        return null;
    }
}

