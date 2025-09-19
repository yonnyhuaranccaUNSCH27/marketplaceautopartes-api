package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ListabeneficiosDTO;
import com.marketplaceautopartes.marketplaceapi.model.Listabeneficios;
import com.marketplaceautopartes.marketplaceapi.service.IListabeneficiosService;
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
@RequestMapping("/api/Listabeneficios")
@RequiredArgsConstructor
public class ListabeneficiosController {
    private final IListabeneficiosService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<ListabeneficiosDTO>> findAll() {
        List<ListabeneficiosDTO> list=mapperUtil.mapList(service.findAll(), ListabeneficiosDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListabeneficiosDTO> findById(@PathVariable Integer id) {
        Listabeneficios obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, ListabeneficiosDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListabeneficiosDTO dto) {
        Listabeneficios obj=service.save(mapperUtil.map(dto, Listabeneficios.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdListabeneficios()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ListabeneficiosDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody ListabeneficiosDTO dto) {
        dto.setIdListabeneficios(id);
        Listabeneficios obj=service.update(id, mapperUtil.map(dto, Listabeneficios.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, ListabeneficiosDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
