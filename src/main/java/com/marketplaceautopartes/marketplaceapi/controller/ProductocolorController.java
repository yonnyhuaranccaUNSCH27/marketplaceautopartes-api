package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ProductocolorDTO;
import com.marketplaceautopartes.marketplaceapi.model.Productocolor;
import com.marketplaceautopartes.marketplaceapi.service.IProductocolorService;
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
@RequestMapping("/api/productocolor")
@RequiredArgsConstructor
public class ProductocolorController {

    private final IProductocolorService productocolorService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ProductocolorDTO>> findAll() {
        List<ProductocolorDTO> list = mapperUtil.mapList(productocolorService.findAll(), ProductocolorDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductocolorDTO> findById(@PathVariable("id") Integer id) {
        Productocolor obj = productocolorService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ProductocolorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProductocolorDTO dto) {
        Productocolor obj = productocolorService.save(mapperUtil.map(dto, Productocolor.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProductocolor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductocolorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ProductocolorDTO dto) {
        dto.setIdProductocolor(id);
        Productocolor obj = productocolorService.update(id, mapperUtil.map(dto, Productocolor.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ProductocolorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        productocolorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

