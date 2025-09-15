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
public class RolDTO {
    private Integer idRol;

    @NotBlank(message = "Es obligatorio")
    private String descripcion;
}
