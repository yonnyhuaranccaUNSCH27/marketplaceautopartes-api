package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiposervicioDTO {
    private Integer idTiposervicio;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;

    @NotNull(message = "Es obligatorio")
    private int estado;
}
