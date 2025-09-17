package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.MovimientoclienteDTO;
import com.marketplaceautopartes.marketplaceapi.model.Movimientocliente;
import com.marketplaceautopartes.marketplaceapi.service.IMovimientoclienteService;
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
@RequestMapping("/api/movimientocliente")
@RequiredArgsConstructor
public class MovimientoclienteController {
    private final IMovimientoclienteService movimientoclienteService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MovimientoclienteDTO>> findAll() {
        List<MovimientoclienteDTO> list = mapperUtil.mapList(movimientoclienteService.findAll(), MovimientoclienteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoclienteDTO> findById(@PathVariable("id") Integer id) {
        Movimientocliente obj = movimientoclienteService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, MovimientoclienteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MovimientoclienteDTO dto) {
        Movimientocliente obj = movimientoclienteService.save(mapperUtil.map(dto, Movimientocliente.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMovimientocliente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoclienteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MovimientoclienteDTO dto) {
        dto.setIdMovimientocliente(id);
        Movimientocliente obj = movimientoclienteService.update(id, mapperUtil.map(dto, Movimientocliente.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MovimientoclienteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        movimientoclienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
