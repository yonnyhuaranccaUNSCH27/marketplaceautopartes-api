package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.TiendaDTO;
import com.marketplaceautopartes.marketplaceapi.model.Tienda;
import com.marketplaceautopartes.marketplaceapi.service.ITiendaService;
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
@RequestMapping("/api/tienda")
@RequiredArgsConstructor
@Tag(name = "tbl_tienda")
public class TiendaController {
    private final ITiendaService tiendaService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista todo el tienda")
    @GetMapping
    public ResponseEntity<List<TiendaDTO>> findAll() {
        List<TiendaDTO> list= mapperUtil.mapList(tiendaService.findAll(), TiendaDTO.class);
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Lista un tienda")
    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> findById(@PathVariable Integer id) {
        Tienda obj= tiendaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TiendaDTO.class));
    }

    @Operation(summary = "Agrega un tienda")
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TiendaDTO dto) {
        Tienda obj = tiendaService.save(mapperUtil.map(dto, Tienda.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTienda()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Actualiza un tienda")
    @PutMapping("/{id}")
    public ResponseEntity<TiendaDTO> update(@Valid @PathVariable Integer id, @RequestBody TiendaDTO dto) {
        dto.setIdTienda(id);
        Tienda obj= tiendaService.update(id, mapperUtil.map(dto, Tienda.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TiendaDTO.class));
    }

    @Operation(summary = "Elimina un tienda")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        tiendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

//  /**
//   * Crea una nueva tienda con certificado
//   */
//  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//  public ResponseEntity<TiendaDTO> crearTienda(
//      @RequestPart("tienda") @Valid TiendaDTO tiendaDTO,
//      @RequestPart(value = "fileCertificado", required = false) MultipartFile certificado) {
//
//    try {
//      TiendaDTO nuevaTienda = tiendaService.crearTienda(tiendaDTO, certificado);
//      return new ResponseEntity<>(nuevaTienda, HttpStatus.CREATED);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
//
//  /**
//   * Actualiza una tienda existente
//   */
//  @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//  public ResponseEntity<TiendaDTO> actualizarTienda(
//      @PathVariable Integer id,
//      @RequestPart("tienda") @Valid TiendaDTO tiendaDTO,
//      @RequestPart(value = "fileCertificado", required = false) MultipartFile certificado) {
//
//    try {
//      TiendaDTO tiendaActualizada = tiendaService.actualizarTienda(id, tiendaDTO, certificado);
//      return new ResponseEntity<>(tiendaActualizada, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//  }
//
//  /**
//   * Descarga el certificado de una tienda
//   */
//  @GetMapping("/{id}/certificado")
//  public ResponseEntity<Resource> descargarCertificado(@PathVariable Integer id) {
//
//    try {
//      TiendaDTO tienda = tiendaService.obtenerPorId(id);
//
//      if (tienda.getFileCertificado() == null) {
//        return ResponseEntity.notFound().build();
//      }
//
//      ByteArrayResource resource = new ByteArrayResource(tienda.getFileCertificado());
//
//      return ResponseEntity.ok()
//          .contentType(MediaType.parseMediaType(tienda.getTipoCertificado()))
//          .header(HttpHeaders.CONTENT_DISPOSITION,
//              "attachment; filename=\"" + tienda.getNombreCertificado() + "\"")
//          .body(resource);
//
//    } catch (Exception e) {
//      return ResponseEntity.notFound().build();
//    }
//  }

}
