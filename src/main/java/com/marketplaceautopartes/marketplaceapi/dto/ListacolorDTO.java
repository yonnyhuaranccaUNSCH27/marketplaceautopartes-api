package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListacolorDTO {
    private Integer idListacolor;

    @JsonBackReference
    private VehiculoDTO vehiculo;

    private ColorDTO color;
}
