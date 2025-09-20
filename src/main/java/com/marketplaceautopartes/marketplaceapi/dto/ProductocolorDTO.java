package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductocolorDTO {
    private Integer idProductocolor;

    @JsonBackReference
    private ProductoDTO producto;

    @NotNull
    private ColorDTO color;
}

