package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Tipooficina;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaDTO {
    private Integer idOficina;

    @NotNull
    private String descripcion;

    private TipooficinaDTO tipooficina;
}
