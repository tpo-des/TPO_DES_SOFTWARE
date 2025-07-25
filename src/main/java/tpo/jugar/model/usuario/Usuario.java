package tpo.jugar.model.usuario;

import jakarta.persistence.*;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.model.jugador.Jugador;
import tpo.jugar.model.notification.EstrategiaDeNotificacion;
import tpo.jugar.model.notification.TipoEstrategiaNotificacion;
import tpo.jugar.model.partido.Partido;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nombreUsuario;
    private String email;
    private String password;
    private NivelUsuario nivel;
    private String ubicacion;
    private TipoEstrategiaNotificacion preferenciaNotificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deporte_id")
    private Deporte deporteFavorito;

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Jugador> juegaEn = new ArrayList<>();


    protected Usuario() {}

    public Usuario(String nombreUsuario, String email, String password, NivelUsuario nivel, TipoEstrategiaNotificacion preferenciaNotificacion, String ubicacion) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nivel = nivel;
        this.preferenciaNotificacion = preferenciaNotificacion;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Deporte getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(Deporte deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public List<Jugador> getJuegaEn() {
        return juegaEn;
    }

    public void setJuegaEn(List<Jugador> juegaEn) {
        this.juegaEn = juegaEn;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}