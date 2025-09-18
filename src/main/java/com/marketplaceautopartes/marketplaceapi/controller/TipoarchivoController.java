package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipoarchivoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipoarchivo;
import com.marketplaceautopartes.marketplaceapi.service.ITipoarchivoService;
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
@RequestMapping("/api/tipoarchivo")
@RequiredArgsConstructor
public class TipoarchivoController {
    private final ITipoarchivoService tipoarchivoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoarchivoDTO>> findAll() {
        List<TipoarchivoDTO> list = mapperUtil.mapList(tipoarchivoService.findAll(), TipoarchivoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoarchivoDTO> findById(@PathVariable("id") Integer id) {
        Tipoarchivo obj = tipoarchivoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoarchivoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoarchivoDTO dto) {
        Tipoarchivo obj = tipoarchivoService.save(mapperUtil.map(dto, Tipoarchivo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoarchivo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoarchivoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoarchivoDTO dto) {
        dto.setIdTipoarchivo(id);
        Tipoarchivo obj = tipoarchivoService.update(id, mapperUtil.map(dto, Tipoarchivo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoarchivoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipoarchivoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
