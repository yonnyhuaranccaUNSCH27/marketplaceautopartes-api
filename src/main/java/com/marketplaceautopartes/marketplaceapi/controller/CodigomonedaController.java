package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CodigomonedaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Codigomoneda;
import com.marketplaceautopartes.marketplaceapi.service.ICodigomonedaService;
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
@RequestMapping("/api/codigomoneda")
@RequiredArgsConstructor
public class CodigomonedaController {
    private final ICodigomonedaService codigomonedaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CodigomonedaDTO>> findAll() {
        List<CodigomonedaDTO> list = mapperUtil.mapList(codigomonedaService.findAll(), CodigomonedaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodigomonedaDTO> findById(@PathVariable("id") Integer id) {
        Codigomoneda obj = codigomonedaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, CodigomonedaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CodigomonedaDTO dto) {
        Codigomoneda obj = codigomonedaService.save(mapperUtil.map(dto, Codigomoneda.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCodigomoneda()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodigomonedaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CodigomonedaDTO dto) {
        dto.setIdCodigomoneda(id);
        Codigomoneda obj = codigomonedaService.update(id, mapperUtil.map(dto, Codigomoneda.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CodigomonedaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        codigomonedaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
