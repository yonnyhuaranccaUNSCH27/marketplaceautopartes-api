package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_plan")

public class Plan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idPlan;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double preciodolar;

    @Column(nullable = false)
    private double preciosoles;

    @Column(nullable = false)
    private double preciodescuentosoles;

    @Column(nullable = false)
    private double preciodescuentodolares;

    @Column(nullable = false)
    private String ciclofacturacion;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String moneda;

    @Column(nullable = false)
    private String maxalmacenamiento;

    @Column(nullable = false)
    private String maxproductos;

    @Column(nullable = false)
    private String maxpedidosmes;

    @Column(nullable = false)
    private Date fcreacion;

    @Column(nullable = false)
    private Date factualizacion;

    @Column(nullable = false)
    private String conFacturacion;

    @Column(nullable = false)
    private Date ffacturacion;


}
