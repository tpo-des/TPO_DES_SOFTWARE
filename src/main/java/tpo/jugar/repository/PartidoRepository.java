package tpo.jugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpo.jugar.model.partido.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

}
