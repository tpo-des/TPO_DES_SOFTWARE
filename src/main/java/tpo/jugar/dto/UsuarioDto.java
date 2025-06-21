package tpo.jugar.dto;

import tpo.jugar.model.usuario.NivelUsuario;

public class UsuarioDto {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String password;
    private NivelUsuario nivel;
    private DeporteDto deporteFavorito;

    public UsuarioDto(Long id, String nombreUsuario, String email, String password, NivelUsuario nivel) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nivel = nivel;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    public void setNivel(NivelUsuario nivel) {
        this.nivel = nivel;
    }

    public DeporteDto getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(DeporteDto deporteDto) {
        this.deporteFavorito = deporteDto;
    }
}
