package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoarchivoDTO {
    private Integer idTipoarchivo;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;
}
