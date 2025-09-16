package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.VehiculoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Vehiculo;
import com.marketplaceautopartes.marketplaceapi.service.IVehiculoService;
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
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final IVehiculoService vehiculoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> findAll() {
        List<VehiculoDTO> list = mapperUtil.mapList(vehiculoService.findAll(), VehiculoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> findById(@PathVariable("id") Integer id) {
        Vehiculo obj = vehiculoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, VehiculoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VehiculoDTO dto) {
        Vehiculo obj = vehiculoService.save(mapperUtil.map(dto, Vehiculo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVehiculo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody VehiculoDTO dto) {
        dto.setIdVehiculo(id);
        Vehiculo obj = vehiculoService.update(id, mapperUtil.map(dto, Vehiculo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, VehiculoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        vehiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
