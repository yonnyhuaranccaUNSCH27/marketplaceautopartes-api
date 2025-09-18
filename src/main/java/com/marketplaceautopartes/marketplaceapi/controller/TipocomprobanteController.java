package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipocomprobanteDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipocomprobante;
import com.marketplaceautopartes.marketplaceapi.service.ITipocomprobanteService;
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
@RequestMapping("/api/tipocomprobante")
@RequiredArgsConstructor
public class TipocomprobanteController {
    private final ITipocomprobanteService tipocomprobanteService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipocomprobanteDTO>> findAll() {
        List<TipocomprobanteDTO> list = mapperUtil.mapList(tipocomprobanteService.findAll(), TipocomprobanteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipocomprobanteDTO> findById(@PathVariable("id") Integer id) {
        Tipocomprobante obj = tipocomprobanteService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipocomprobanteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipocomprobanteDTO dto) {
        Tipocomprobante obj = tipocomprobanteService.save(mapperUtil.map(dto, Tipocomprobante.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipocomprobante()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipocomprobanteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipocomprobanteDTO dto) {
        dto.setIdTipocomprobante(id);
        Tipocomprobante obj = tipocomprobanteService.update(id, mapperUtil.map(dto, Tipocomprobante.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipocomprobanteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipocomprobanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
