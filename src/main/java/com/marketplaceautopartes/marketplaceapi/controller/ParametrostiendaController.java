package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ParametrostiendaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Parametrostienda;
import com.marketplaceautopartes.marketplaceapi.service.IParametrostiendaService;
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
@RequestMapping("/api/Parametrostienda")
@RequiredArgsConstructor
public class ParametrostiendaController {
    private final IParametrostiendaService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<ParametrostiendaDTO>> findAll() {
        List<ParametrostiendaDTO> list=mapperUtil.mapList(service.findAll(), ParametrostiendaDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParametrostiendaDTO> findById(@PathVariable Integer id) {
        Parametrostienda obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, ParametrostiendaDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ParametrostiendaDTO dto) {
        Parametrostienda obj=service.save(mapperUtil.map(dto, Parametrostienda.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdParametrostienda()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParametrostiendaDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody ParametrostiendaDTO dto) {
        dto.setIdParametrostienda(id);
        Parametrostienda obj=service.update(id, mapperUtil.map(dto, Parametrostienda.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, ParametrostiendaDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
