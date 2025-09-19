package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.PlansuscripcionDTO;
import com.marketplaceautopartes.marketplaceapi.model.Plansuscripcion;
import com.marketplaceautopartes.marketplaceapi.service.IPlansuscripcionService;
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
@RequestMapping("/api/Plansuscripcion")
@RequiredArgsConstructor
public class PlansuscripcionController {
    private final IPlansuscripcionService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<PlansuscripcionDTO>> findAll() {
        List<PlansuscripcionDTO> list=mapperUtil.mapList(service.findAll(), PlansuscripcionDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlansuscripcionDTO> findById(@PathVariable Integer id) {
        Plansuscripcion obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, PlansuscripcionDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PlansuscripcionDTO dto) {
        Plansuscripcion obj=service.save(mapperUtil.map(dto, Plansuscripcion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdPlansuscripcion()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlansuscripcionDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody PlansuscripcionDTO dto) {
        dto.setIdPlansuscripcion(id);
        Plansuscripcion obj=service.update(id, mapperUtil.map(dto, Plansuscripcion.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, PlansuscripcionDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
