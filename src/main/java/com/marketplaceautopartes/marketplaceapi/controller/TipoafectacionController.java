package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipoafectacionDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipoafectacion;
import com.marketplaceautopartes.marketplaceapi.service.ITipoafectacionService;
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
@RequestMapping("/api/tipoafectacion")
@RequiredArgsConstructor
public class TipoafectacionController {
    private final ITipoafectacionService tipoafectacionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoafectacionDTO>> findAll() {
        List<TipoafectacionDTO> list = mapperUtil.mapList(tipoafectacionService.findAll(), TipoafectacionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoafectacionDTO> findById(@PathVariable("id") Integer id) {
        Tipoafectacion obj = tipoafectacionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoafectacionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoafectacionDTO dto) {
        Tipoafectacion obj = tipoafectacionService.save(mapperUtil.map(dto, Tipoafectacion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoafectacio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoafectacionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoafectacionDTO dto) {
        dto.setIdTipoafectacio(id);
        Tipoafectacion obj = tipoafectacionService.update(id, mapperUtil.map(dto, Tipoafectacion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoafectacionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipoafectacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
