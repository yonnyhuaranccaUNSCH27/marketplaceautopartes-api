package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.LugarDTO;
import com.marketplaceautopartes.marketplaceapi.model.Lugar;
import com.marketplaceautopartes.marketplaceapi.service.ILugarService;
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
@RequestMapping("/api/lugar")
@RequiredArgsConstructor
public class LugarController {
    private final ILugarService lugarService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<LugarDTO>> findAll() {
        List<LugarDTO> list = mapperUtil.mapList(lugarService.findAll(), LugarDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LugarDTO> findById(@PathVariable("id") Integer id) {
        Lugar obj = lugarService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, LugarDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody LugarDTO dto) {
        Lugar obj = lugarService.save(mapperUtil.map(dto, Lugar.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdLugar()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LugarDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody LugarDTO dto) {
        dto.setIdLugar(id);
        Lugar obj = lugarService.update(id, mapperUtil.map(dto, Lugar.class));
        return ResponseEntity.ok(mapperUtil.map(obj, LugarDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        lugarService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
