package tpo.jugar.service;

import tpo.jugar.model.partido.Partido;

import java.util.List;

public interface PartidoService {
    List<Partido> findAll();
    Partido getById(long id);
    Partido create(Partido partido);
    Partido finalizar(long id);
    Partido cancelar(long id);
}
