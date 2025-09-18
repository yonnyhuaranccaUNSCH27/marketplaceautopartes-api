package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_compra")
public class Compra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idCompra;

    private Double total;
    private Double igv;
    private LocalDateTime fechaEntrega;
    private String numGuia;
    private String placaVehiculo;
    private  LocalDateTime fechaEmision;
    private String observacion;
    private String estadoGuia;
    private String origen;
    private String destino;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_proveedor"))
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_usuario"))
    private Usuario usuario;
}
