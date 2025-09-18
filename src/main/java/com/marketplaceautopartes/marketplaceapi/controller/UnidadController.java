package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.UnidadDTO;
import com.marketplaceautopartes.marketplaceapi.model.Unidad;
import com.marketplaceautopartes.marketplaceapi.service.IUnidadService;
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
@RequestMapping("/api/unidad")
@RequiredArgsConstructor
public class UnidadController {
    private final IUnidadService unidadService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<UnidadDTO>> findAll() {
        List<UnidadDTO> list = mapperUtil.mapList(unidadService.findAll(), UnidadDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadDTO> findById(@PathVariable("id") Integer id) {
        Unidad obj = unidadService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, UnidadDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UnidadDTO dto) {
        Unidad obj = unidadService.save(mapperUtil.map(dto, Unidad.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUnidad()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody UnidadDTO dto) {
        dto.setIdUnidad(id);
        Unidad obj = unidadService.update(id, mapperUtil.map(dto, Unidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, UnidadDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        unidadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
