package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.EntidadespersonasDTO;
import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;
import com.marketplaceautopartes.marketplaceapi.service.IEntidadespersonasService;
import com.marketplaceautopartes.marketplaceapi.util.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("api/entidadespersonas")
@RequiredArgsConstructor
@Tag(name = "tbl_entidadespersonas")
public class EntidadespersonasController {
    private final IEntidadespersonasService entidadespersonasService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el entidadespersonas")
    @GetMapping
    public ResponseEntity<List<EntidadespersonasDTO>> findAll(){
        List<EntidadespersonasDTO> list=mapperUtil.mapList(entidadespersonasService.findAll(), EntidadespersonasDTO.class);
        //sino funciona borrar body(list) --> ok(list)
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Lista un entidadespersonas")
    @GetMapping("/{id}")
    public ResponseEntity<EntidadespersonasDTO> findById(@PathVariable Integer id){
        Entidadespersonas obj=entidadespersonasService.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, EntidadespersonasDTO.class));
    }



    @Operation(summary = "Agrega un entidadespersonas")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EntidadespersonasDTO dto){
        Entidadespersonas obj=entidadespersonasService.save(mapperUtil.map(dto, Entidadespersonas.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEntidadespersonas()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un entidadespersonas")
    @PutMapping("/{id}")
    public ResponseEntity<EntidadespersonasDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EntidadespersonasDTO dto){
        dto.setIdEntidadespersonas(id);
        Entidadespersonas obj=entidadespersonasService.update(id, mapperUtil.map(dto, Entidadespersonas.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EntidadespersonasDTO.class));
    }

    @Operation(summary = "Elimina un entidadespersonas")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        entidadespersonasService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
