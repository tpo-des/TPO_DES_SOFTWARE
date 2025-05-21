package tpo.modelo;

public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contraseña;
    private String deporteFavorito; // opcional (Puede ser null)
    private Nivel nivel; // opcional (Puede ser null)
    private String localidad;

    public enum Nivel { PRINCIPIANTE, INTERMEDIO, AVANZADO }

    public Usuario(String nombreUsuario, String correo, String contraseña, String deporteFavorito, Nivel nivel, String localidad) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.deporteFavorito = deporteFavorito;
        this.nivel = nivel;
        this.localidad = localidad;
    }

    // Getters y Setters

    public String getLocalidad() {
        return localidad;
    }

    public boolean verificarCredenciales(String correo, String contraseña) {
        return this.correo.equals(correo) && this.contraseña.equals(contraseña);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(String deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
