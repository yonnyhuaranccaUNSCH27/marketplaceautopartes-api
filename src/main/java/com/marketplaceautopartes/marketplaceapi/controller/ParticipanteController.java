package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ParticipanteDTO;
import com.marketplaceautopartes.marketplaceapi.model.Participante;
import com.marketplaceautopartes.marketplaceapi.service.IParticipanteService;
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
@RequestMapping("/api/participante")
@RequiredArgsConstructor
public class ParticipanteController {
    private final IParticipanteService participanteService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>> findAll() {
        List<ParticipanteDTO> list = mapperUtil.mapList(participanteService.findAll(), ParticipanteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> findById(@PathVariable("id") Integer id) {
        Participante obj = participanteService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ParticipanteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ParticipanteDTO dto) {
        Participante obj = participanteService.save(mapperUtil.map(dto, Participante.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdParticipante()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ParticipanteDTO dto) {
        dto.setIdParticipante(id);
        Participante obj = participanteService.update(id, mapperUtil.map(dto, Participante.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ParticipanteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        participanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
