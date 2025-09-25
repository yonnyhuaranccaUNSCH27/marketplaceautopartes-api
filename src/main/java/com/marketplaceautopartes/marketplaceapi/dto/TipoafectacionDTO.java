package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoafectacionDTO {
    private Integer idTipoafectacio;

    @NotNull(message = "Es obligatorio")
    private String codigo;

    @NotNull(message = "Es obligatorio")
    private String descripcion;

    @NotNull(message = "Es obligatorio")
    private String nombreafectacion;
}
