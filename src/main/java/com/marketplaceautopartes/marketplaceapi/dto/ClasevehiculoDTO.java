package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasevehiculoDTO {
    private Integer idClasevehiculo;

    @NotNull
    private String descripcion;
}
