package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.SubdominioDTO;
import com.marketplaceautopartes.marketplaceapi.model.Subdominio;
import com.marketplaceautopartes.marketplaceapi.service.ISubdominioService;
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
@RequestMapping("/api/Subdominio")
@RequiredArgsConstructor
public class SubdominioController {
    private final ISubdominioService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<SubdominioDTO>> findAll() {
        List<SubdominioDTO> list=mapperUtil.mapList(service.findAll(), SubdominioDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubdominioDTO> findById(@PathVariable Integer id) {
        Subdominio obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, SubdominioDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SubdominioDTO dto) {
        Subdominio obj=service.save(mapperUtil.map(dto, Subdominio.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdSubdominio()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<SubdominioDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody SubdominioDTO dto) {
        dto.setIdSubdominio(id);
        Subdominio obj=service.update(id, mapperUtil.map(dto, Subdominio.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, SubdominioDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
