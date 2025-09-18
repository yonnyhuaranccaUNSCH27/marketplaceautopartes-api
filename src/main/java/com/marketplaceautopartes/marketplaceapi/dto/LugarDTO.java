package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LugarDTO {
    private Integer idLugar;

    @NotBlank(message = "Es obligatorio")
    private String nombre;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;

    private Integer idImpresora;
}
