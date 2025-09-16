package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {
    private Integer idMarca;

    @NotNull
    private String descripcion;
}
