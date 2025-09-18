package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.BancoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Banco;
import com.marketplaceautopartes.marketplaceapi.service.IBancoService;
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
@RequestMapping("/api/banco")
@RequiredArgsConstructor
public class BancoController {
    private final IBancoService bancoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<BancoDTO>> findAll() {
        List<BancoDTO> list = mapperUtil.mapList(bancoService.findAll(), BancoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoDTO> findById(@PathVariable("id") Integer id) {
        Banco obj = bancoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, BancoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody BancoDTO dto) {
        Banco obj = bancoService.save(mapperUtil.map(dto, Banco.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdBanco()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BancoDTO dto) {
        dto.setIdBanco(id);
        Banco obj = bancoService.update(id, mapperUtil.map(dto, Banco.class));
        return ResponseEntity.ok(mapperUtil.map(obj, BancoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        bancoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
