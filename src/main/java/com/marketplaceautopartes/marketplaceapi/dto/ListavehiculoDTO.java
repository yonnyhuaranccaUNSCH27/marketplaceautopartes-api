package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListavehiculoDTO {
    private Integer idListavehiculo;

    private VehiculoDTO vehiculo;

    @JsonBackReference
    private ProductoDTO producto;
}
