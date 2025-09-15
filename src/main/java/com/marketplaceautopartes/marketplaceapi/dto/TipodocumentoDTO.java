package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipodocumentoDTO {
    private Integer idTipodocumento;

    @NotBlank(message = "Es obligatorio")
    private String codigo;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;
}
