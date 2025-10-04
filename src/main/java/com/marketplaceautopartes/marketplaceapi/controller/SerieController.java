package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.SerieDTO;
import com.marketplaceautopartes.marketplaceapi.model.Serie;
import com.marketplaceautopartes.marketplaceapi.service.ISerieService;
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
@RequestMapping("/api/serie")
@RequiredArgsConstructor
public class SerieController {
    private final ISerieService serieService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SerieDTO>> findAll() {
        List<SerieDTO> list = mapperUtil.mapList(serieService.findAll(), SerieDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieDTO> findById(@PathVariable("id") Integer id) {
        Serie obj = serieService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, SerieDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SerieDTO dto) {
        Serie obj = serieService.save(mapperUtil.map(dto, Serie.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSerie()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SerieDTO dto) {
        dto.setIdSerie(id);
        Serie obj = serieService.update(id, mapperUtil.map(dto, Serie.class));
        return ResponseEntity.ok(mapperUtil.map(obj, SerieDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        serieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
