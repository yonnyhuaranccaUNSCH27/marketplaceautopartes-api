package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Integer idCategoria;

    @NotBlank(message = "Es obligatorio")
    private String codigo;

    @NotBlank(message = "Es obligatorio")
    private String nombre;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;
}
