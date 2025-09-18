package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_listaventa")
public class Listaventa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idlistaVenta;

    @Column(nullable = false)
    private String item;
    private int cantidad;
    private Double valorunitario;
    private Double precioUnitario;
    private Double igv;
    private Double porcentajeIgv;
    private Double descuento;
    private  Double valortotal;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_ListaVenta"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false, foreignKey = @ForeignKey(name = "FK_Venta_ListaVenta"))
    private Venta venta;
}
