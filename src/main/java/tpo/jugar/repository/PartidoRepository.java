package tpo.jugar.repository;

import org.springframework.data.repository.CrudRepository;
import tpo.jugar.model.partido.Partido;

public interface PartidoRepository extends CrudRepository<Partido, Long> {

}
