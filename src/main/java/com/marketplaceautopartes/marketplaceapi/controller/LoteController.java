package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.LoteDTO;
import com.marketplaceautopartes.marketplaceapi.model.Lote;
import com.marketplaceautopartes.marketplaceapi.service.ILoteService;
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
@RequestMapping("/api/lote")
@RequiredArgsConstructor
public class LoteController {
    private final ILoteService loteService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<LoteDTO>> findAll() {
        List<LoteDTO> list = mapperUtil.mapList(loteService.findAll(), LoteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoteDTO> findById(@PathVariable("id") Integer id) {
        Lote obj = loteService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, LoteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody LoteDTO dto) {
        Lote obj = loteService.save(mapperUtil.map(dto, Lote.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdLote()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody LoteDTO dto) {
        dto.setIdLote(id);
        Lote obj = loteService.update(id, mapperUtil.map(dto, Lote.class));
        return ResponseEntity.ok(mapperUtil.map(obj, LoteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        loteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
