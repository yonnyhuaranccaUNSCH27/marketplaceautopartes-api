package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.DetalleplansuscripcionDTO;
import com.marketplaceautopartes.marketplaceapi.model.Detalleplansuscripcion;
import com.marketplaceautopartes.marketplaceapi.service.IDetalleplansuscripcionService;
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
@RequestMapping("/api/detalleplansuscripcion")
@RequiredArgsConstructor
public class DetalleplansuscripcionController {
    private final IDetalleplansuscripcionService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<DetalleplansuscripcionDTO>> findAll() {
        List<DetalleplansuscripcionDTO> list=mapperUtil.mapList(service.findAll(), DetalleplansuscripcionDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetalleplansuscripcionDTO> findById(@PathVariable Integer id) {
        Detalleplansuscripcion obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, DetalleplansuscripcionDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DetalleplansuscripcionDTO dto) {
        Detalleplansuscripcion obj=service.save(mapperUtil.map(dto, Detalleplansuscripcion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdDetalleplansuscripcion()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetalleplansuscripcionDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody DetalleplansuscripcionDTO dto) {
        dto.setIdDetalleplansuscripcion(id);
        Detalleplansuscripcion obj=service.update(id, mapperUtil.map(dto, Detalleplansuscripcion.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, DetalleplansuscripcionDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
