package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ListavehiculoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Listavehiculo;
import com.marketplaceautopartes.marketplaceapi.service.IListavehiculoService;
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
@RequestMapping("/api/listavehiculo")
@RequiredArgsConstructor
public class ListavehiculoController {
    private final IListavehiculoService listavehiculoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListavehiculoDTO>> findAll() {
        List<ListavehiculoDTO> list = mapperUtil.mapList(listavehiculoService.findAll(), ListavehiculoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListavehiculoDTO> findById(@PathVariable("id") Integer id) {
        Listavehiculo obj = listavehiculoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ListavehiculoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListavehiculoDTO dto) {
        Listavehiculo obj = listavehiculoService.save(mapperUtil.map(dto, Listavehiculo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListavehiculo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListavehiculoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListavehiculoDTO dto) {
        dto.setIdListavehiculo(id);
        Listavehiculo obj = listavehiculoService.update(id, mapperUtil.map(dto, Listavehiculo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListavehiculoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listavehiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
