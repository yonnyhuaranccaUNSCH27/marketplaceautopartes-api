package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.CarroceriaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Carroceria;
import com.marketplaceautopartes.marketplaceapi.service.ICarroceriaService;
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
@RequestMapping("/api/carroceria")
@RequiredArgsConstructor
public class CarroceriaController {
    private final ICarroceriaService carroceriaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CarroceriaDTO>> findAll() {
        List<CarroceriaDTO> list = mapperUtil.mapList(carroceriaService.findAll(), CarroceriaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroceriaDTO> findById(@PathVariable("id") Integer id) {
        Carroceria obj = carroceriaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, CarroceriaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CarroceriaDTO dto) {
        Carroceria obj = carroceriaService.save(mapperUtil.map(dto, Carroceria.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCarroceria()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CarroceriaDTO dto) {
        dto.setIdCarroceria(id);
        Carroceria obj = carroceriaService.update(id, mapperUtil.map(dto, Carroceria.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CarroceriaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        carroceriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
