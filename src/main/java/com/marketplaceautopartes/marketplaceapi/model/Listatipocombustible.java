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
@Table(name = "tbl_listatipocombustible")
public class Listatipocombustible {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idListatipocombustible;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo",foreignKey = @ForeignKey(name = "FK_LISTATIPOCOMBUSTIBLE_VEHICULO"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_tipocombustible",foreignKey = @ForeignKey(name = "FK_LISTATIPOCOMBUSTIBLE_TIPOCOMBUSTIBLE"))
    private Tipocombustible tipocombustible;
}
