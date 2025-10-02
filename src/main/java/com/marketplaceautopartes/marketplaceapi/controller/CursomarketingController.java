package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CursomarketingDTO;
import com.marketplaceautopartes.marketplaceapi.model.Cursomarketing;
import com.marketplaceautopartes.marketplaceapi.service.ICursomarketingService;
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
@RequestMapping("/api/Cursomarketing")
@RequiredArgsConstructor
public class CursomarketingController {
    private final ICursomarketingService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<CursomarketingDTO>> findAll() {
        List<CursomarketingDTO> list=mapperUtil.mapList(service.findAll(), CursomarketingDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursomarketingDTO> findById(@PathVariable Integer id) {
        Cursomarketing obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, CursomarketingDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CursomarketingDTO dto) {
        Cursomarketing obj=service.save(mapperUtil.map(dto, Cursomarketing.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdCursomarketing()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CursomarketingDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody CursomarketingDTO dto) {
        dto.setIdCursomarketing(id);
        Cursomarketing obj=service.update(id, mapperUtil.map(dto, Cursomarketing.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, CursomarketingDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
