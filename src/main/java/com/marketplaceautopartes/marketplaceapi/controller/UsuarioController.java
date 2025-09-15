package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.UsuarioDTO;
import com.marketplaceautopartes.marketplaceapi.model.Usuario;
import com.marketplaceautopartes.marketplaceapi.service.IUsuarioService;
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
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@Tag(name = "tbl_usuario")
public class UsuarioController {
    private final IUsuarioService usuarioService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el usuario")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> list=mapperUtil.mapList(usuarioService.findAll(), UsuarioDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un usuario")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Integer id) {
        Usuario obj=usuarioService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, UsuarioDTO.class));
    }

    @Operation(summary = "Agrega un usuario")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UsuarioDTO dto) {
        Usuario obj=usuarioService.save(mapperUtil.map(dto, Usuario.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un usuario")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody UsuarioDTO dto) {
        dto.setIdUsuario(id);
        Usuario obj=usuarioService.update(id, mapperUtil.map(dto, Usuario.class));
        return ResponseEntity.ok(mapperUtil.map(obj, UsuarioDTO.class));
    }

    @Operation(summary = "Elimina un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UsuarioDTO> findByUsername(@PathVariable("username") String username) {
        Usuario obj=usuarioService.findByUsername(username);
        return ResponseEntity.ok(mapperUtil.map(obj, UsuarioDTO.class));
    }

}
