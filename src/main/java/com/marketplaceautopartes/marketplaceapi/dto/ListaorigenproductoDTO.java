package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaorigenproductoDTO {
    private Integer idListaorigenproducto;

    @JsonBackReference
    private ProductoDTO producto;

    private OrigenDTO origen;
}
