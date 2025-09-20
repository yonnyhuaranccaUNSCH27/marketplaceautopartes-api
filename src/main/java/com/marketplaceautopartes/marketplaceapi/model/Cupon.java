package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_cupon")
public class Cupon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idCupon;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer tipoDescuento; // "porcentaje" o "fijo"

    @Column(nullable = false)
    private Integer valorDescuento; // valor del descuento

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    private Boolean activo;

    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_tienda", nullable = false)
    private Tienda tienda;

    private String codigo;
    @Column(nullable = false)
    private String descripcion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDate.now();
    }
}
