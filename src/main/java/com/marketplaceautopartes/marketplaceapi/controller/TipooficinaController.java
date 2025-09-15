package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipooficinaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipooficina;
import com.marketplaceautopartes.marketplaceapi.service.ITipooficinaService;
import com.marketplaceautopartes.marketplaceapi.util.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/tipooficina")
@RequiredArgsConstructor
@Tag(name = "tbl_tipooficina")
public class TipooficinaController {
    private final ITipooficinaService tipooficinaService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el tipo de oficina")
    @GetMapping
    public ResponseEntity<List<TipooficinaDTO>> findAll() {
        List<TipooficinaDTO> list=mapperUtil.mapList(tipooficinaService.findAll(), TipooficinaDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un tipo de oficina")
    @GetMapping("/{id}")
    public ResponseEntity<TipooficinaDTO> findById(@PathVariable("id") Integer id) {
        Tipooficina obj=tipooficinaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipooficinaDTO.class));
    }

    @Operation(summary = "Agrega un tipo de oficina")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipooficinaDTO dto) {
        Tipooficina obj= tipooficinaService.save(mapperUtil.map(dto, Tipooficina.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipooficina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un tipo de oficina")
    @PutMapping("/{id}")
    public ResponseEntity<TipooficinaDTO> update(@Valid @PathVariable("id") Integer id ,@RequestBody TipooficinaDTO dto) {
        dto.setIdTipooficina(id);
        Tipooficina obj=tipooficinaService.update(id, mapperUtil.map(dto, Tipooficina.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipooficinaDTO.class));
    }

    @Operation(summary = "Elimina un tipo de oficina")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipooficinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
