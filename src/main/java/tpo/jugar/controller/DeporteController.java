package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpo.jugar.dto.DeporteDto;
import tpo.jugar.mapper.DeporteMapper;
import tpo.jugar.model.deporte.Deporte;
import tpo.jugar.service.DeporteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deportes")
public class DeporteController {

    private final DeporteService service;

    public DeporteController(DeporteService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<DeporteDto>> getAllDeportes() {
        return ResponseEntity.ok(
                service.all()
                        .stream()
                        .map(DeporteMapper::toDto)
                        .toList()
        );
    }

    @PostMapping
    ResponseEntity<DeporteDto> createDeporte(@RequestBody DeporteDto deporteDto) {
        Deporte deporte = new Deporte();
        deporte.setNombre(deporteDto.getNombre());
        return ResponseEntity.ok(DeporteMapper.toDto(service.create(deporte)));
    }

    @GetMapping("{id}")
    ResponseEntity<DeporteDto> getDeporteById(Long id) {
        Deporte deporte = service.findById(id);
        return ResponseEntity.ok(DeporteMapper.toDto(deporte));
    }
}
