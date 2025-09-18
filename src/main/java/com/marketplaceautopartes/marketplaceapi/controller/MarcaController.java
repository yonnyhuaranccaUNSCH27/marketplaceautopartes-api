package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.MarcaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Marca;
import com.marketplaceautopartes.marketplaceapi.service.IMarcaService;
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
@RequestMapping("/api/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final IMarcaService marcaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> findAll() {
        List<MarcaDTO> list = mapperUtil.mapList(marcaService.findAll(), MarcaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> findById(@PathVariable("id") Integer id) {
        Marca obj = marcaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, MarcaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MarcaDTO dto) {
        Marca obj = marcaService.save(mapperUtil.map(dto, Marca.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMarca()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MarcaDTO dto) {
        dto.setIdMarca(id);
        Marca obj = marcaService.update(id, mapperUtil.map(dto, Marca.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MarcaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
