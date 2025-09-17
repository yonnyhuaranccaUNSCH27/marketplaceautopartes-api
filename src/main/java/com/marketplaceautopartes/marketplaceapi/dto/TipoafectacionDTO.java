package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoafectacionDTO {
    private Integer idTipoafectacio;

    @NotBlank(message = "Es obligatorio")
    private String codigo;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;
}
