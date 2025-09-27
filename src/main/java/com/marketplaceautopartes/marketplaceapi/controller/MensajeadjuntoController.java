package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.MensajeadjuntoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Mensajeadjunto;
import com.marketplaceautopartes.marketplaceapi.service.IMensajeadjuntoService;
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
@RequestMapping("/api/mensajeadjunto")
@RequiredArgsConstructor
@Tag(name = "tbl_mensajeadjunto")
public class MensajeadjuntoController {
    private final IMensajeadjuntoService mensajeadjuntoService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo los mensajeadjuntos")
    @GetMapping
    public ResponseEntity<List<MensajeadjuntoDTO>> findAll() {
        List<MensajeadjuntoDTO> list=mapperUtil.mapList(mensajeadjuntoService.findAll(), MensajeadjuntoDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un mensajeadjunto")
    @GetMapping("/{id}")
    public ResponseEntity<MensajeadjuntoDTO> findById(@PathVariable Integer id) {
        Mensajeadjunto obj=mensajeadjuntoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, MensajeadjuntoDTO.class));
    }

    @Operation(summary = "Agrega un mensajeadjunto")
    @PutMapping("/{id}")
    public ResponseEntity<MensajeadjuntoDTO> update(@Valid @PathVariable Integer id, @RequestBody MensajeadjuntoDTO dto) {
        dto.setIdMensajeadjunto(id);
        Mensajeadjunto obj=mensajeadjuntoService.update(id, mapperUtil.map(dto, Mensajeadjunto.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MensajeadjuntoDTO.class));
    }

    @Operation(summary = "Actualiza un mensajeadjunto")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MensajeadjuntoDTO dto) {
        Mensajeadjunto obj = mensajeadjuntoService.save(mapperUtil.map(dto, Mensajeadjunto.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMensajeadjunto()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Elimina un mensajeadjunto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        mensajeadjuntoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
