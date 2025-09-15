package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.RolDTO;
import com.marketplaceautopartes.marketplaceapi.model.Rol;
import com.marketplaceautopartes.marketplaceapi.service.IRolService;
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
@RequestMapping("/api/rol")
@RequiredArgsConstructor
@Tag(name = "tbl_rol")
public class RolController {
    private final IRolService rolService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el rol")
    @GetMapping
    public ResponseEntity<List<RolDTO>> findAll() {
        List<RolDTO> list= mapperUtil.mapList(rolService.findAll(), RolDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un rol")
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> findById(@PathVariable Integer id) {
        Rol obj= rolService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, RolDTO.class));
    }

    @Operation(summary = "Agrega un rol")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody RolDTO dto) {
        Rol obj = rolService.save(mapperUtil.map(dto, Rol.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRol()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un rol")
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@Valid @PathVariable Integer id, @RequestBody RolDTO dto) {
        dto.setIdRol(id);
        Rol obj= rolService.update(id, mapperUtil.map(dto, Rol.class));
        return ResponseEntity.ok(mapperUtil.map(obj, RolDTO.class));
    }

    @Operation(summary = "Elimina un rol")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
