package tpo.jugar.service;

import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.usuario.NivelUsuario;
import tpo.jugar.model.usuario.Usuario;

import java.util.List;

public interface PartidoService {
    List<Partido> findAll();
    List<Partido> findNecesitadosDeJugadoresBy(String ubicacion);
    List<Partido> findNivelMinimo(NivelUsuario nivel);
    Partido getById(long id);
    Partido create(Partido partido);
    Partido update(Partido partido);
    Partido finalizar(long id);
    Partido cancelar(long id);
}
