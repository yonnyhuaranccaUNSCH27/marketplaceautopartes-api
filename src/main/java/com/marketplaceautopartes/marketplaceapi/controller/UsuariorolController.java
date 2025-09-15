package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.UsuariorolDTO;
import com.marketplaceautopartes.marketplaceapi.model.Usuariorol;
import com.marketplaceautopartes.marketplaceapi.service.IUsuariorolService;
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
@RequestMapping("/api/usuariorol")
@RequiredArgsConstructor
@Tag(name = "tbl_usuariorol")
public class UsuariorolController {
    private final IUsuariorolService usuariorolService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el usuario rol")
    @GetMapping
    public ResponseEntity<List<UsuariorolDTO>> findAll() {
        List<UsuariorolDTO> list= mapperUtil.mapList(usuariorolService.findAll(), UsuariorolDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un usuario rol")
    @GetMapping("/{id}")
    public ResponseEntity<UsuariorolDTO> findById(@PathVariable("id") Integer id) {
        Usuariorol obj=usuariorolService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, UsuariorolDTO.class));
    }

    @Operation(summary = "Agrega un usuario rol")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UsuariorolDTO dto) {
        Usuariorol obj=usuariorolService.save(mapperUtil.map(dto, Usuariorol.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuariorol()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un usuario rol")
    @PutMapping("/{id}")
    public ResponseEntity<UsuariorolDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody UsuariorolDTO dto) {
        dto.setIdUsuariorol(id);
        Usuariorol obj= usuariorolService.update(id, mapperUtil.map(dto, Usuariorol.class));
        return ResponseEntity.ok(mapperUtil.map(obj, UsuariorolDTO.class));
    }

    @Operation(summary = "Elimina un usuario rol")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        usuariorolService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
