package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ListacolorDTO;
import com.marketplaceautopartes.marketplaceapi.model.Listacolor;
import com.marketplaceautopartes.marketplaceapi.service.IListacolorService;
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
@RequestMapping("/api/listacolor")
@RequiredArgsConstructor
public class ListacolorController {
    private final IListacolorService listacolorService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListacolorDTO>> findAll() {
        List<ListacolorDTO> list = mapperUtil.mapList(listacolorService.findAll(), ListacolorDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListacolorDTO> findById(@PathVariable("id") Integer id) {
        Listacolor obj = listacolorService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ListacolorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListacolorDTO dto) {
        Listacolor obj = listacolorService.save(mapperUtil.map(dto, Listacolor.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListacolor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListacolorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListacolorDTO dto) {
        dto.setIdListacolor(id);
        Listacolor obj = listacolorService.update(id, mapperUtil.map(dto, Listacolor.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListacolorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listacolorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
