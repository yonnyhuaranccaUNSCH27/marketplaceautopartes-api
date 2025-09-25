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
@Table(name = "tbl_listavehiculo")
public class Listavehiculo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idListavehiculo;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo",foreignKey = @ForeignKey(name = "FK_LISTAVEHICULO_VEHICULO"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_producto",foreignKey = @ForeignKey(name = "FK_LISTAVEHICULO_PRODUCTO"))
    private Producto producto;
}
