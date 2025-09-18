package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipocombustibleDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipocombustible;
import com.marketplaceautopartes.marketplaceapi.service.ITipocombustibleService;
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
@RequestMapping("/api/tipocombustible")
@RequiredArgsConstructor
public class TipocombustibleController {
    private final ITipocombustibleService tipocombustibleService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipocombustibleDTO>> findAll() {
        List<TipocombustibleDTO> list = mapperUtil.mapList(tipocombustibleService.findAll(), TipocombustibleDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipocombustibleDTO> findById(@PathVariable("id") Integer id) {
        Tipocombustible obj = tipocombustibleService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipocombustibleDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipocombustibleDTO dto) {
        Tipocombustible obj = tipocombustibleService.save(mapperUtil.map(dto, Tipocombustible.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipocombustible()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipocombustibleDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipocombustibleDTO dto) {
        dto.setIdTipocombustible(id);
        Tipocombustible obj = tipocombustibleService.update(id, mapperUtil.map(dto, Tipocombustible.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipocombustibleDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipocombustibleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
