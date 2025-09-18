package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    private VehiculoDTO vehiculo;

    private TipocombustibleDTO tipocombustible;
}
