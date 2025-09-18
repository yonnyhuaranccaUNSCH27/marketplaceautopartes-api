package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipoventaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipoventa;
import com.marketplaceautopartes.marketplaceapi.service.ITipoventaService;
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
@RequestMapping("/api/tipoventa")
@RequiredArgsConstructor
public class TipoventaController {
    private final ITipoventaService tipoventaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoventaDTO>> findAll() {
        List<TipoventaDTO> list = mapperUtil.mapList(tipoventaService.findAll(), TipoventaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoventaDTO> findById(@PathVariable("id") Integer id) {
        Tipoventa obj = tipoventaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoventaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoventaDTO dto) {
        Tipoventa obj = tipoventaService.save(mapperUtil.map(dto, Tipoventa.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoventa()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoventaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoventaDTO dto) {
        dto.setIdTipoventa(id);
        Tipoventa obj = tipoventaService.update(id, mapperUtil.map(dto, Tipoventa.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoventaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipoventaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
