package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Integer idPlan;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @NotNull
    private double preciodolar;

    private double preciosoles;

    private double preciodescuentosoles;

    private double preciodescuentodolares;

    private String moneda;

    private String ciclofacturacion;

    private String estado;

    private String maxalmacenamiento;

    private String maxproductos;

    private String maxpedidosmes;

    private Date fcreacion;
    private Date factualizacion;

    private String conFacturacion;

    private Date ffacturacion;


}
