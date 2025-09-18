package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ListatipocombustibleDTO;
import com.marketplaceautopartes.marketplaceapi.model.Listatipocombustible;
import com.marketplaceautopartes.marketplaceapi.service.IListatipocombustibleService;
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
@RequestMapping("/api/listatipocombustible")
@RequiredArgsConstructor
public class ListatipocombustibleController {
    private final IListatipocombustibleService listatipocombustibleService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListatipocombustibleDTO>> findAll() {
        List<ListatipocombustibleDTO> list = mapperUtil.mapList(listatipocombustibleService.findAll(), ListatipocombustibleDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListatipocombustibleDTO> findById(@PathVariable("id") Integer id) {
        Listatipocombustible obj = listatipocombustibleService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ListatipocombustibleDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListatipocombustibleDTO dto) {
        Listatipocombustible obj = listatipocombustibleService.save(mapperUtil.map(dto, Listatipocombustible.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListatipocombustible()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListatipocombustibleDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListatipocombustibleDTO dto) {
        dto.setIdListatipocombustible(id);
        Listatipocombustible obj = listatipocombustibleService.update(id, mapperUtil.map(dto, Listatipocombustible.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListatipocombustibleDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listatipocombustibleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
