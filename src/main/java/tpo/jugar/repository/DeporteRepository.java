package tpo.jugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpo.jugar.model.deporte.Deporte;

public interface DeporteRepository extends JpaRepository<Deporte, Long> {

}
