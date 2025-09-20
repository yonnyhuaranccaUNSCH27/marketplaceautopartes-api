package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ClientecuponDTO;
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
@RequestMapping("/api/clientecupon")
@RequiredArgsConstructor
public class ClientecuponController {
    private final ICuponService clientecuponService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ClientecuponDTO>> findAll() {
        List<ClientecuponDTO> list = mapperUtil.mapList(clientecuponService.findAll(), ClientecuponDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientecuponDTO> findById(@PathVariable("id") Integer id) {
        Cupon obj = clientecuponService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ClientecuponDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ClientecuponDTO dto) {
        Cupon obj = clientecuponService.save(mapperUtil.map(dto, Cupon.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCupon()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientecuponDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ClientecuponDTO dto) {
        dto.setIdClientecupon(id);
        Cupon obj = clientecuponService.update(id, mapperUtil.map(dto, Cupon.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ClientecuponDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        clientecuponService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
