package com.marketplaceautopartes.marketplaceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListacolorDTO {
    private Integer idListacolor;

    private VehiculoDTO vehiculo;
    private ColorDTO color;
}
