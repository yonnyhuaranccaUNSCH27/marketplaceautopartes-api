package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.SesionusuarioDTO;
import com.marketplaceautopartes.marketplaceapi.model.Sesionusuario;
import com.marketplaceautopartes.marketplaceapi.service.ISesionusuarioService;
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
@RequestMapping("/api/Sesionusuario")
@RequiredArgsConstructor
public class SesionusuarioController {
    private final ISesionusuarioService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<SesionusuarioDTO>> findAll() {
        List<SesionusuarioDTO> list=mapperUtil.mapList(service.findAll(), SesionusuarioDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SesionusuarioDTO> findById(@PathVariable Integer id) {
        Sesionusuario obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, SesionusuarioDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SesionusuarioDTO dto) {
        Sesionusuario obj=service.save(mapperUtil.map(dto, Sesionusuario.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdSesionusuario()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<SesionusuarioDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody SesionusuarioDTO dto) {
        dto.setIdSesionusuario(id);
        Sesionusuario obj=service.update(id, mapperUtil.map(dto, Sesionusuario.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, SesionusuarioDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
