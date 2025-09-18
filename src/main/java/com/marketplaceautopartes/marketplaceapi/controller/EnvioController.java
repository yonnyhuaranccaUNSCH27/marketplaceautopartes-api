package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.EnvioDTO;
import com.marketplaceautopartes.marketplaceapi.model.Envio;
import com.marketplaceautopartes.marketplaceapi.service.IEnvioService;
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
@RequestMapping("/api/envio")
@RequiredArgsConstructor
public class EnvioController {
    private final IEnvioService envioService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EnvioDTO>> findAll() {
        List<EnvioDTO> list = mapperUtil.mapList(envioService.findAll(), EnvioDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> findById(@PathVariable("id") Integer id) {
        Envio obj = envioService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, EnvioDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EnvioDTO dto) {
        Envio obj = envioService.save(mapperUtil.map(dto, Envio.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEnvio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EnvioDTO dto) {
        dto.setIdEnvio(id);
        Envio obj = envioService.update(id, mapperUtil.map(dto, Envio.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EnvioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        envioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
