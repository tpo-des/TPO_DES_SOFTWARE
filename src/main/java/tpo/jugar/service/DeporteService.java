package tpo.jugar.service;

import tpo.jugar.model.deporte.Deporte;

import java.util.List;

public interface DeporteService {

    List<Deporte> all();
    Deporte findById(Long id);
    Deporte create(Deporte deporte);
}
