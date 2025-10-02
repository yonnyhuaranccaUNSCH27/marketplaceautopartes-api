package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.ParticipantemensajeriaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Participantemensajeria;
import com.marketplaceautopartes.marketplaceapi.service.IParticipantemensajeriaService;
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
@RequestMapping("/api/participantemensajeria")
@RequiredArgsConstructor
public class ParticipantemensajeriaController {
    private final IParticipantemensajeriaService participantemensajeriaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ParticipantemensajeriaDTO>> findAll() {
        List<ParticipantemensajeriaDTO> list = mapperUtil.mapList(participantemensajeriaService.findAll(), ParticipantemensajeriaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantemensajeriaDTO> findById(@PathVariable("id") Integer id) {
        Participantemensajeria obj = participantemensajeriaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ParticipantemensajeriaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ParticipantemensajeriaDTO dto) {
        Participantemensajeria obj = participantemensajeriaService.save(mapperUtil.map(dto, Participantemensajeria.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdParticipantemensajeria()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantemensajeriaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ParticipantemensajeriaDTO dto) {
        dto.setIdParticipantemensajeria(id);
        Participantemensajeria obj = participantemensajeriaService.update(id, mapperUtil.map(dto, Participantemensajeria.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ParticipantemensajeriaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        participantemensajeriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
