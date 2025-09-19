package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListabeneficiosDTO {
    private Integer idListabeneficios;

    @NotNull
    private String descripcion;

    @NotNull
    private String estado;

    private PlanDTO plan;

}
