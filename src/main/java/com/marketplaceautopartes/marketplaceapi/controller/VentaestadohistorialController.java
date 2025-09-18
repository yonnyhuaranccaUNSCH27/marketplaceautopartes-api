package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.VentaestadohistorialDTO;
import com.marketplaceautopartes.marketplaceapi.model.Ventaestadohistorial;
import com.marketplaceautopartes.marketplaceapi.service.IVentaestadohistorialService;
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
@RequestMapping("/api/ventaestadohistorial")
@RequiredArgsConstructor
public class VentaestadohistorialController {
    private final IVentaestadohistorialService ventaestadohistorialService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<VentaestadohistorialDTO>> findAll() {
        List<VentaestadohistorialDTO> list = mapperUtil.mapList(ventaestadohistorialService.findAll(), VentaestadohistorialDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaestadohistorialDTO> findById(@PathVariable("id") Integer id) {
        Ventaestadohistorial obj = ventaestadohistorialService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, VentaestadohistorialDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VentaestadohistorialDTO dto) {
        Ventaestadohistorial obj = ventaestadohistorialService.save(mapperUtil.map(dto, Ventaestadohistorial.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVentaestadohistorial()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaestadohistorialDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody VentaestadohistorialDTO dto) {
        dto.setIdVentaestadohistorial(id);
        Ventaestadohistorial obj = ventaestadohistorialService.update(id, mapperUtil.map(dto, Ventaestadohistorial.class));
        return ResponseEntity.ok(mapperUtil.map(obj, VentaestadohistorialDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        ventaestadohistorialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
