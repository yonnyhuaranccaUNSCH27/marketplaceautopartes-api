package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.HistorialconsultasDTO;
import com.marketplaceautopartes.marketplaceapi.model.Historialconsultas;
import com.marketplaceautopartes.marketplaceapi.service.IHistorialconsultasService;
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
@RequestMapping("/api/historialconsultas")
@RequiredArgsConstructor
public class HistorialconsultasController {
    private final IHistorialconsultasService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<HistorialconsultasDTO>> findAll() {
        List<HistorialconsultasDTO> list=mapperUtil.mapList(service.findAll(), HistorialconsultasDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HistorialconsultasDTO> findById(@PathVariable Integer id) {
        Historialconsultas obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, HistorialconsultasDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody HistorialconsultasDTO dto) {
        Historialconsultas obj=service.save(mapperUtil.map(dto, Historialconsultas.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdHistorialconsultas()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<HistorialconsultasDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody HistorialconsultasDTO dto) {
        dto.setIdHistorialconsultas(id);
        Historialconsultas obj=service.update(id, mapperUtil.map(dto, Historialconsultas.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, HistorialconsultasDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
