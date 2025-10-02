package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CuponcategoriaDTO;
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
@RequestMapping("/api/cuponcategoria")
@RequiredArgsConstructor
public class CuponcategoriaController {
    private final IEnvioService cuponcategoriaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CuponcategoriaDTO>> findAll() {
        List<CuponcategoriaDTO> list = mapperUtil.mapList(cuponcategoriaService.findAll(), CuponcategoriaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuponcategoriaDTO> findById(@PathVariable("id") Integer id) {
        Envio obj = cuponcategoriaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, CuponcategoriaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CuponcategoriaDTO dto) {
        Envio obj = cuponcategoriaService.save(mapperUtil.map(dto, Envio.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEnvio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuponcategoriaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CuponcategoriaDTO dto) {
        dto.setIdCuponcategoria(id);
        Envio obj = cuponcategoriaService.update(id, mapperUtil.map(dto, Envio.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CuponcategoriaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        cuponcategoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
