package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.EstadoventaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Estadoventa;
import com.marketplaceautopartes.marketplaceapi.service.IEstadoventaService;
import com.marketplaceautopartes.marketplaceapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/estadoventa")
@RequiredArgsConstructor
public class EstadoventaController {
    private final IEstadoventaService estadoventaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EstadoventaDTO>> findAll() {
        List<EstadoventaDTO> list = mapperUtil.mapList(estadoventaService.findAll(), EstadoventaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoventaDTO> findById(@PathVariable("id") Integer id) {
        Estadoventa obj = estadoventaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, EstadoventaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EstadoventaDTO dto) {
        Estadoventa obj = estadoventaService.save(mapperUtil.map(dto, Estadoventa.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEstadoventa()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoventaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EstadoventaDTO dto) {
        dto.setIdEstadoVenta(id);
        Estadoventa obj = estadoventaService.update(id, mapperUtil.map(dto, Estadoventa.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EstadoventaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        estadoventaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
