package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.MensajeDTO;
import com.marketplaceautopartes.marketplaceapi.model.Mensaje;
import com.marketplaceautopartes.marketplaceapi.service.IMensajeService;
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
@RequestMapping("/api/mensaje")
@RequiredArgsConstructor
@Tag(name = "tbl_mensaje")
public class MensajeController {
    private final IMensajeService mensajeService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo los mensajes")
    @GetMapping
    public ResponseEntity<List<MensajeDTO>> findAll() {
        List<MensajeDTO> list=mapperUtil.mapList(mensajeService.findAll(), MensajeDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un mensaje")
    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO> findById(@PathVariable Integer id) {
        Mensaje obj=mensajeService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, MensajeDTO.class));
    }

    @Operation(summary = "Agrega un mensaje")
    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO> update(@Valid @PathVariable Integer id, @RequestBody MensajeDTO dto) {
        dto.setIdMensaje(id);
        Mensaje obj=mensajeService.update(id, mapperUtil.map(dto, Mensaje.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MensajeDTO.class));
    }

    @Operation(summary = "Actualiza un mensaje")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MensajeDTO dto) {
        Mensaje obj = mensajeService.save(mapperUtil.map(dto, Mensaje.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMensaje()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Elimina un mensaje")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        mensajeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
