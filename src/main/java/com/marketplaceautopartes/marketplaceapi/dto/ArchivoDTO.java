package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivoDTO {
    private Integer idArchivo;

    @NotBlank(message = "Es obligatorio")
    private String urll;

    private String descripcion;

    @NotNull(message = "Es obligatorio")
    private Integer idTipoarchivo;

    @NotNull(message = "Es obligatorio")
    private Integer idProducto;
}
