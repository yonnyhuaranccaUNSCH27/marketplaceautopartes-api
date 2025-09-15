package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {
    private Integer idCargo;

    @NotBlank(message = "Es obligatorio")
    private String codigo;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;
}
