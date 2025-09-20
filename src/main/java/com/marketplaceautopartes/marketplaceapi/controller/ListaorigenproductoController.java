package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ListaorigenproductoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Listaorigenproducto;
import com.marketplaceautopartes.marketplaceapi.service.IListaorigenproductoService;
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
@RequestMapping("/api/listaorigenproducto")
@RequiredArgsConstructor
public class ListaorigenproductoController {
    private final IListaorigenproductoService listaorigenproductoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListaorigenproductoDTO>> findAll() {
        List<ListaorigenproductoDTO> list = mapperUtil.mapList(listaorigenproductoService.findAll(), ListaorigenproductoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaorigenproductoDTO> findById(@PathVariable("id") Integer id) {
        Listaorigenproducto obj = listaorigenproductoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ListaorigenproductoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListaorigenproductoDTO dto) {
        Listaorigenproducto obj = listaorigenproductoService.save(mapperUtil.map(dto, Listaorigenproducto.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListaorigenproducto()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaorigenproductoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListaorigenproductoDTO dto) {
        dto.setIdListaorigenproducto(id);
        Listaorigenproducto obj = listaorigenproductoService.update(id, mapperUtil.map(dto, Listaorigenproducto.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListaorigenproductoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listaorigenproductoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
