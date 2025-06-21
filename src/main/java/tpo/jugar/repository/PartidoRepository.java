package tpo.jugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpo.jugar.model.partido.Partido;
import tpo.jugar.model.partido.estado.TipoEstadoPartido;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    List<Partido> findByEstadoAndUbicacion(TipoEstadoPartido estado, String ubicacion);
}
