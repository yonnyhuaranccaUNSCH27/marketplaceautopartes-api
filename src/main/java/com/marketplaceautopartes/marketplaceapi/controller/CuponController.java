package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CuponDTO;
import com.marketplaceautopartes.marketplaceapi.model.Cupon;
import com.marketplaceautopartes.marketplaceapi.service.ICuponService;
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
@RequestMapping("/api/cupon")
@RequiredArgsConstructor
public class CuponController {
    private final ICuponService cuponService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CuponDTO>> findAll() {
        List<CuponDTO> list = mapperUtil.mapList(cuponService.findAll(), CuponDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuponDTO> findById(@PathVariable("id") Integer id) {
        Cupon obj = cuponService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, CuponDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CuponDTO dto) {
        Cupon obj = cuponService.save(mapperUtil.map(dto, Cupon.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCupon()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuponDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CuponDTO dto) {
        dto.setIdCupon(id);
        Cupon obj = cuponService.update(id, mapperUtil.map(dto, Cupon.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CuponDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        cuponService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
