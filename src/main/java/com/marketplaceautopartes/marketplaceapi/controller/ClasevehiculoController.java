package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ClasevehiculoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Clasevehiculo;
import com.marketplaceautopartes.marketplaceapi.service.IClasevehiculoService;
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
@RequestMapping("/api/clasevehiculo")
@RequiredArgsConstructor
public class ClasevehiculoController {
    private final IClasevehiculoService clasevehiculoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ClasevehiculoDTO>> findAll() {
        List<ClasevehiculoDTO> list = mapperUtil.mapList(clasevehiculoService.findAll(), ClasevehiculoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasevehiculoDTO> findById(@PathVariable("id") Integer id) {
        Clasevehiculo obj = clasevehiculoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ClasevehiculoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ClasevehiculoDTO dto) {
        Clasevehiculo obj = clasevehiculoService.save(mapperUtil.map(dto, Clasevehiculo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdClasevehiculo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasevehiculoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ClasevehiculoDTO dto) {
        dto.setIdClasevehiculo(id);
        Clasevehiculo obj = clasevehiculoService.update(id, mapperUtil.map(dto, Clasevehiculo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ClasevehiculoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        clasevehiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
