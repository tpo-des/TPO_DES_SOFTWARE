package tpo.modelo.partido.busqueda;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;

public class UsuarioJuegaEnElPartidoEstrategia implements EstrategiaDeSelecionDePartidos {

    private Usuario usuario;

    public UsuarioJuegaEnElPartidoEstrategia(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean esCumplidaPor(Partido partido) {
        return partido.getJugadores().contains(usuario);
    }
}
