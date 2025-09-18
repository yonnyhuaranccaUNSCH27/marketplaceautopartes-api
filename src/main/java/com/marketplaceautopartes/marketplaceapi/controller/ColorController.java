package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ColorDTO;
import com.marketplaceautopartes.marketplaceapi.model.Color;
import com.marketplaceautopartes.marketplaceapi.service.IColorService;
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
@RequestMapping("/api/color")
@RequiredArgsConstructor
public class ColorController {
    private final IColorService colorService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ColorDTO>> findAll() {
        List<ColorDTO> list = mapperUtil.mapList(colorService.findAll(), ColorDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColorDTO> findById(@PathVariable("id") Integer id) {
        Color obj = colorService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ColorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ColorDTO dto) {
        Color obj = colorService.save(mapperUtil.map(dto, Color.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdColor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ColorDTO dto) {
        dto.setIdColor(id);
        Color obj = colorService.update(id, mapperUtil.map(dto, Color.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ColorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        colorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
