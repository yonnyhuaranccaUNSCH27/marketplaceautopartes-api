package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ImpresoraDTO;
import com.marketplaceautopartes.marketplaceapi.model.Impresora;
import com.marketplaceautopartes.marketplaceapi.service.IImpresoraService;
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
@RequestMapping("/api/impresora")
@RequiredArgsConstructor
public class ImpresoraController {
    private final IImpresoraService impresoraService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ImpresoraDTO>> findAll() {
        List<ImpresoraDTO> list = mapperUtil.mapList(impresoraService.findAll(), ImpresoraDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImpresoraDTO> findById(@PathVariable("id") Integer id) {
        Impresora obj = impresoraService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ImpresoraDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ImpresoraDTO dto) {
        Impresora obj = impresoraService.save(mapperUtil.map(dto, Impresora.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdImpresora()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImpresoraDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ImpresoraDTO dto) {
        dto.setIdImpresora(id);
        Impresora obj = impresoraService.update(id, mapperUtil.map(dto, Impresora.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ImpresoraDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        impresoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
