package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CitasasesoriaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Citasasesoria;
import com.marketplaceautopartes.marketplaceapi.service.ICitasasesoriaService;
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
@RequestMapping("/api/citasasesoria")
@RequiredArgsConstructor
public class CitasasesoriaController {
    private final ICitasasesoriaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CitasasesoriaDTO>> findAll() {
        List<CitasasesoriaDTO> list=mapperUtil.mapList(service.findAll(), CitasasesoriaDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CitasasesoriaDTO> findById(@PathVariable Integer id) {
        Citasasesoria obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, CitasasesoriaDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CitasasesoriaDTO dto) {
        Citasasesoria obj=service.save(mapperUtil.map(dto, Citasasesoria.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdCitasasesoria()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CitasasesoriaDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody CitasasesoriaDTO dto) {
        dto.setIdCitasasesoria(id);
        Citasasesoria obj=service.update(id, mapperUtil.map(dto, Citasasesoria.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, CitasasesoriaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
