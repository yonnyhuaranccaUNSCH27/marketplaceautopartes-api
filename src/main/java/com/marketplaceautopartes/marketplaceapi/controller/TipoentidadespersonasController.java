package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TipoentidadespersonasDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tipoentidadespersonas;
import com.marketplaceautopartes.marketplaceapi.service.ITipoentidadespersonasService;
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
@RequestMapping("/api/tipoentidadespersonas")
@RequiredArgsConstructor
@Tag(name = "tbl_tipoentidadespersonas")
public class TipoentidadespersonasController {
    private final ITipoentidadespersonasService tipoentidadespersonasService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el tipo de documento")
    @GetMapping
    public ResponseEntity<List<TipoentidadespersonasDTO>> findAll() {
        List<TipoentidadespersonasDTO> list=mapperUtil.mapList(tipoentidadespersonasService.findAll(), TipoentidadespersonasDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un tipo de documento")
    @GetMapping("/{id}")
    public ResponseEntity<TipoentidadespersonasDTO> findById(@PathVariable("id") Integer id) {
        Tipoentidadespersonas obj=tipoentidadespersonasService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoentidadespersonasDTO.class));
    }

    @Operation(summary = "Agrega un tipo de documento")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoentidadespersonasDTO dto) {
        Tipoentidadespersonas obj=tipoentidadespersonasService.save(mapperUtil.map(dto, Tipoentidadespersonas.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoentidadespersonas()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un tipo de documento")
    @PutMapping("/{id}")
    public ResponseEntity<TipoentidadespersonasDTO> update(@Valid  @PathVariable("id") Integer id, @RequestBody TipoentidadespersonasDTO dto) {
        dto.setIdTipoentidadespersonas(id);
        Tipoentidadespersonas obj=tipoentidadespersonasService.update(id,mapperUtil.map(dto, Tipoentidadespersonas.class));
        return ResponseEntity.ok(mapperUtil.map(obj,TipoentidadespersonasDTO.class));
    }

    @Operation(summary = "Elimina un tipo de documento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipoentidadespersonasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
