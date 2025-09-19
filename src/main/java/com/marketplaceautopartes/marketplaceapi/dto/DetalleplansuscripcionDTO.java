package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleplansuscripcionDTO {
    private Integer idDetalleplansuscripcion;

    private PlanDTO plan;

    private PlansuscripcionDTO plansuscripcion;

}
