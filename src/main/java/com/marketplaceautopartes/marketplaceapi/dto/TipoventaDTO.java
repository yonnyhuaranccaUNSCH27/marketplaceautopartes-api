package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoventaDTO {
    private Integer idTipoventa;

    @NotNull
    private String descripcion;
}
