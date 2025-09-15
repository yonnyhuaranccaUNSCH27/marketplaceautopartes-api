package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveleducacionDTO {
    private Integer idNiveleducacion;

    @NotNull
    private String descripcion;
}
