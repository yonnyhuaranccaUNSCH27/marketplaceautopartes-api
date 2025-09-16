package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.NotifitiendaventaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Notifitiendaventa;
import com.marketplaceautopartes.marketplaceapi.service.INotifitiendaventaService;
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
@RequestMapping("/api/notifitiendaventa")
@RequiredArgsConstructor
public class NotifitiendaventaController {
    private final INotifitiendaventaService notifitiendaventaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<NotifitiendaventaDTO>> findAll() {
        List<NotifitiendaventaDTO> list = mapperUtil.mapList(notifitiendaventaService.findAll(), NotifitiendaventaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotifitiendaventaDTO> findById(@PathVariable("id") Integer id) {
        Notifitiendaventa obj = notifitiendaventaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, NotifitiendaventaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody NotifitiendaventaDTO dto) {
        Notifitiendaventa obj = notifitiendaventaService.save(mapperUtil.map(dto, Notifitiendaventa.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdNotifitiendaventa()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotifitiendaventaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody NotifitiendaventaDTO dto) {
        dto.setIdNotifitiendaventa(id);
        Notifitiendaventa obj = notifitiendaventaService.update(id, mapperUtil.map(dto, Notifitiendaventa.class));
        return ResponseEntity.ok(mapperUtil.map(obj, NotifitiendaventaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        notifitiendaventaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
