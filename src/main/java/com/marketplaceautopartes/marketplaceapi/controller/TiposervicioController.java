package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TiposervicioDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tiposervicio;
import com.marketplaceautopartes.marketplaceapi.service.ITiposervicioService;
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
@RequestMapping("/api/tiposervicio")
@RequiredArgsConstructor
public class TiposervicioController {
    private final ITiposervicioService tiposervicioService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TiposervicioDTO>> findAll() {
        List<TiposervicioDTO> list = mapperUtil.mapList(tiposervicioService.findAll(), TiposervicioDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposervicioDTO> findById(@PathVariable("id") Integer id) {
        Tiposervicio obj = tiposervicioService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TiposervicioDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TiposervicioDTO dto) {
        Tiposervicio obj = tiposervicioService.save(mapperUtil.map(dto, Tiposervicio.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTiposervicio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiposervicioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TiposervicioDTO dto) {
        dto.setIdTiposervicio(id);
        Tiposervicio obj = tiposervicioService.update(id, mapperUtil.map(dto, Tiposervicio.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TiposervicioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tiposervicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
