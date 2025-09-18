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
@Table(name = "tbl_parametrostienda")
public class Parametrostienda {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idParametrostienda;

    @Column(nullable = false)
    private String claveparametro;

    @Column(nullable = false)
    private Integer stockMinimo;

    @Column(nullable = false)
    private String valorparametro;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fcreacion;

    @Column(nullable = false)
    private Date factualizacion;

    @ManyToOne
    @JoinColumn(name = "idTienda",nullable = false, foreignKey= @ForeignKey(name = "fk_parametrostienda_tienda"))
    private Tienda tienda;
}
