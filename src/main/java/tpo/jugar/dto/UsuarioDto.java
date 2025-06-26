package tpo.jugar.dto;

import tpo.jugar.model.notification.TipoEstrategiaNotificacion;
import tpo.jugar.model.usuario.NivelUsuario;

public class UsuarioDto {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String password;
    private NivelUsuario nivel;
    private TipoEstrategiaNotificacion preferenciaNotificacion;
    private String ubicacion;
    private DeporteDto deporteFavorito;

    public UsuarioDto(Long id, String nombreUsuario, String email, String password, NivelUsuario nivel, String ubicacion) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nivel = nivel;
        this.ubicacion = ubicacion;
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

    public TipoEstrategiaNotificacion getPreferenciaNotificacion() {
        return preferenciaNotificacion;
    }

    public void setPreferenciaNotificacion(TipoEstrategiaNotificacion preferenciaNotificacion) {
        this.preferenciaNotificacion = preferenciaNotificacion;
    }

    public DeporteDto getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(DeporteDto deporteDto) {
        this.deporteFavorito = deporteDto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
