package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.PersonacitasasesoriaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Personacitasasesoria;
import com.marketplaceautopartes.marketplaceapi.service.IPersonacitasasesoriaService;
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
@RequestMapping("/api/Personacitasasesoria")
@RequiredArgsConstructor
public class PersonacitasasesoriaController {
    private final IPersonacitasasesoriaService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<PersonacitasasesoriaDTO>> findAll() {
        List<PersonacitasasesoriaDTO> list=mapperUtil.mapList(service.findAll(), PersonacitasasesoriaDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonacitasasesoriaDTO> findById(@PathVariable Integer id) {
        Personacitasasesoria obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, PersonacitasasesoriaDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PersonacitasasesoriaDTO dto) {
        Personacitasasesoria obj=service.save(mapperUtil.map(dto, Personacitasasesoria.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdPersonacitasasesoria()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonacitasasesoriaDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody PersonacitasasesoriaDTO dto) {
        dto.setIdPersonacitasasesoria(id);
        Personacitasasesoria obj=service.update(id, mapperUtil.map(dto, Personacitasasesoria.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, PersonacitasasesoriaDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
