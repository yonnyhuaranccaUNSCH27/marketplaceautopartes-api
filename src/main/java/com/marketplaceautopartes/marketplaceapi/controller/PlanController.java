package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.PlanDTO;
import com.marketplaceautopartes.marketplaceapi.model.Plan;
import com.marketplaceautopartes.marketplaceapi.service.IPlanService;
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
@RequestMapping("/api/Plan")
@RequiredArgsConstructor
public class PlanController {
    private final IPlanService service;
    private final MapperUtil mapperUtil;
    
    @GetMapping
    public ResponseEntity<List<PlanDTO>> findAll() {
        List<PlanDTO> list=mapperUtil.mapList(service.findAll(), PlanDTO.class);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> findById(@PathVariable Integer id) {
        Plan obj=service.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, PlanDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PlanDTO dto) {
        Plan obj=service.save(mapperUtil.map(dto, Plan.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdPlan()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlanDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody PlanDTO dto) {
        dto.setIdPlan(id);
        Plan obj=service.update(id, mapperUtil.map(dto, Plan.class));
        return ResponseEntity.ok().body(mapperUtil.map(obj, PlanDTO.class));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
