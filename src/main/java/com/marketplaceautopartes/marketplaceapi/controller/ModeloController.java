package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ModeloDTO;
import com.marketplaceautopartes.marketplaceapi.model.Modelo;
import com.marketplaceautopartes.marketplaceapi.service.IModeloService;
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
@RequestMapping("/api/modelo")
@RequiredArgsConstructor
public class ModeloController {
    private final IModeloService modeloService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> findAll() {
        List<ModeloDTO> list = mapperUtil.mapList(modeloService.findAll(), ModeloDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> findById(@PathVariable("id") Integer id) {
        Modelo obj = modeloService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ModeloDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ModeloDTO dto) {
        Modelo obj = modeloService.save(mapperUtil.map(dto, Modelo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdModelo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ModeloDTO dto) {
        dto.setIdModelo(id);
        Modelo obj = modeloService.update(id, mapperUtil.map(dto, Modelo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ModeloDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        modeloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
