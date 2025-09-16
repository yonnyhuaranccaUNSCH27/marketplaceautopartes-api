package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.FormapagoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Formapago;
import com.marketplaceautopartes.marketplaceapi.service.IFormapagoService;
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
@RequestMapping("/api/formapago")
@RequiredArgsConstructor
public class FormapagoController {
    private final IFormapagoService formapagoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<FormapagoDTO>> findAll() {
        List<FormapagoDTO> list = mapperUtil.mapList(formapagoService.findAll(), FormapagoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormapagoDTO> findById(@PathVariable("id") Integer id) {
        Formapago obj = formapagoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, FormapagoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FormapagoDTO dto) {
        Formapago obj = formapagoService.save(mapperUtil.map(dto, Formapago.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdFormapago()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormapagoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody FormapagoDTO dto) {
        dto.setIdFormapago(id);
        Formapago obj = formapagoService.update(id, mapperUtil.map(dto, Formapago.class));
        return ResponseEntity.ok(mapperUtil.map(obj, FormapagoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        formapagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
