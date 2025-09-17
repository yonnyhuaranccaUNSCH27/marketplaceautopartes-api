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
@Table(name = "tbl_movimientocliente")
public class Movimientocliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idMovimientocliente;

    private LocalDateTime fechaCreada;
    private Double totalcompra;
    private String preferenciapaga;

    @ManyToOne
    @JoinColumn(name = "idEntidadespersonas")
    private Entidadespersonas entidadespersonas;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;
}
