package tpo.jugar.mapper;

import tpo.jugar.dto.DeporteDto;
import tpo.jugar.model.deporte.Deporte;

public class DeporteMapper {

    public static DeporteDto toDto(Deporte deporte) {
        DeporteDto dto = new DeporteDto();
        dto.setId(deporte.getId());
        dto.setNombre(deporte.getNombre());
        return dto;
    }
}
