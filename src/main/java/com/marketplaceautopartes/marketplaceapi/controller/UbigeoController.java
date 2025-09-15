package com.marketplaceautopartes.marketplaceapi.controller;

import com.marketplaceautopartes.marketplaceapi.dto.UbigeoDTO;
import com.marketplaceautopartes.marketplaceapi.model.Ubigeo;
import com.marketplaceautopartes.marketplaceapi.service.IUbigeoService;
import com.marketplaceautopartes.marketplaceapi.util.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/ubigeo")
@RequiredArgsConstructor
@Tag(name = "tbl_ubigeo")
public class UbigeoController {
    private final IUbigeoService ubigeoService;
    private final MapperUtil mapperUtil;

    @Operation(summary = "Lista un ubigeo")
    @GetMapping("/{id}")
    public ResponseEntity<UbigeoDTO> findById(@PathVariable Integer id){
        Ubigeo obj=ubigeoService.findById(id);
        return ResponseEntity.ok().body(mapperUtil.map(obj, UbigeoDTO.class));
    }

    @Operation(summary = "Lista departamentos")
    @GetMapping("/departamentos")
    public ResponseEntity<List<UbigeoDTO>> getDepartments() {
        List<UbigeoDTO> departments = mapperUtil.mapList(ubigeoService.getDepartments(), UbigeoDTO.class);
        return ResponseEntity.ok(departments);
    }

    @Operation(summary = "Lista provincias")
    @GetMapping("/provincias/{department}")
    public ResponseEntity<List<UbigeoDTO>> getProvincias(@PathVariable String department) {
        List<UbigeoDTO> provincias = mapperUtil.mapList(ubigeoService.getProviciasByDepartment(department),UbigeoDTO.class) ;
        return ResponseEntity.ok(provincias);
    }

    @Operation(summary = "Lista distritos")
    @GetMapping("/distritos")
    public ResponseEntity<List<UbigeoDTO>> getDistritos(
            @RequestParam String departamento,
            @RequestParam String provincia)  {
        List<UbigeoDTO> ubigeos = mapperUtil.mapList(ubigeoService.getDistritos(departamento, provincia),UbigeoDTO.class);
        return ResponseEntity.ok(ubigeos);
    }

}