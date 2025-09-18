package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaventaDTO {
    private Integer idlistaVenta;
    private String item;
    private int cantidad;
    private Double valorunitario;
    private Double precioUnitario;
    private Double igv;
    private Double porcentajeIgv;
    private Double descuento;
    private Double valortotal;
    private ProductoDTO producto;
    @JsonBackReference
    private VentaDTO venta;
}

