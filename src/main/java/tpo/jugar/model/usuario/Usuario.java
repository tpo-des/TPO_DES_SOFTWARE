package tpo.jugar.model.usuario;

import jakarta.persistence.*;
import tpo.jugar.model.jugador.Jugador;
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

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Jugador> juegaEn = new ArrayList<>();


    protected Usuario() {}

    public Usuario(String nombreUsuario, String email, String password) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
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

    public List<Jugador> getJuegaEn() {
        return juegaEn;
    }

    public void setJuegaEn(List<Jugador> juegaEn) {
        this.juegaEn = juegaEn;
    }
}