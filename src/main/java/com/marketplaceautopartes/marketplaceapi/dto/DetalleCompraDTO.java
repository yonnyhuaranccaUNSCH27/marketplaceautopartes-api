package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCompraDTO {
    private Integer idDetalleCompra;

    private Integer cantidad;
    private String item;
    private Double subtotal;

    @NotNull(message = "Es obligatorio")
    private Integer idCompra;

    @NotNull(message = "Es obligatorio")
    private Integer idProducto;
}
