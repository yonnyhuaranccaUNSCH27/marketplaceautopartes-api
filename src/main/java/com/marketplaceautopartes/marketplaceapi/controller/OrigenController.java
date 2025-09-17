package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.OrigenDTO;
import com.marketplaceautopartes.marketplaceapi.model.Origen;
import com.marketplaceautopartes.marketplaceapi.service.IOrigenService;
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
@RequestMapping("/api/origen")
@RequiredArgsConstructor
public class OrigenController {
    private final IOrigenService origenService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<OrigenDTO>> findAll() {
        List<OrigenDTO> list = mapperUtil.mapList(origenService.findAll(), OrigenDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrigenDTO> findById(@PathVariable("id") Integer id) {
        Origen obj = origenService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, OrigenDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody OrigenDTO dto) {
        Origen obj = origenService.save(mapperUtil.map(dto, Origen.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOrigen()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrigenDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody OrigenDTO dto) {
        dto.setIdOrigen(id);
        Origen obj = origenService.update(id, mapperUtil.map(dto, Origen.class));
        return ResponseEntity.ok(mapperUtil.map(obj, OrigenDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        origenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
