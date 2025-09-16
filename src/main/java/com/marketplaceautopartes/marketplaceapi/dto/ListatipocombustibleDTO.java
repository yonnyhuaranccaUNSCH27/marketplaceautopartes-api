package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListatipocombustibleDTO {
    private Integer idListatipocombustible;

    private VehiculoDTO vehiculo;
    private TipocombustibleDTO tipocombustible;
}
