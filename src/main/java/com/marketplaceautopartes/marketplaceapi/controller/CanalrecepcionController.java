package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CanalrecepcionDTO;
import com.marketplaceautopartes.marketplaceapi.model.Canalrecepcion;
import com.marketplaceautopartes.marketplaceapi.service.ICanalrecepcionService;
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
@RequestMapping("/api/canalrecepcion")
@RequiredArgsConstructor
public class CanalrecepcionController {
    private final ICanalrecepcionService canalrecepcionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CanalrecepcionDTO>> findAll() {
        List<CanalrecepcionDTO> list = mapperUtil.mapList(canalrecepcionService.findAll(), CanalrecepcionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanalrecepcionDTO> findById(@PathVariable("id") Integer id) {
        Canalrecepcion obj = canalrecepcionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, CanalrecepcionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CanalrecepcionDTO dto) {
        Canalrecepcion obj = canalrecepcionService.save(mapperUtil.map(dto, Canalrecepcion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCanalrecepcion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CanalrecepcionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CanalrecepcionDTO dto) {
        dto.setIdCanalrecepcion(id);
        Canalrecepcion obj = canalrecepcionService.update(id, mapperUtil.map(dto, Canalrecepcion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CanalrecepcionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        canalrecepcionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
