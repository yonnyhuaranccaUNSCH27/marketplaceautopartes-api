package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CuentabancariaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Cuentabancaria;
import com.marketplaceautopartes.marketplaceapi.service.ICuentabancariaService;
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
@RequestMapping("/api/cuentabancaria")
@RequiredArgsConstructor
public class CuentabancariaController {
    private final ICuentabancariaService cuentabancariaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CuentabancariaDTO>> findAll() {
        List<CuentabancariaDTO> list = mapperUtil.mapList(cuentabancariaService.findAll(), CuentabancariaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentabancariaDTO> findById(@PathVariable("id") Integer id) {
        Cuentabancaria obj = cuentabancariaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, CuentabancariaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CuentabancariaDTO dto) {
        Cuentabancaria obj = cuentabancariaService.save(mapperUtil.map(dto, Cuentabancaria.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCuentabancaria()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentabancariaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CuentabancariaDTO dto) {
        dto.setIdCuentabancaria(id);
        Cuentabancaria obj = cuentabancariaService.update(id, mapperUtil.map(dto, Cuentabancaria.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CuentabancariaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        cuentabancariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
