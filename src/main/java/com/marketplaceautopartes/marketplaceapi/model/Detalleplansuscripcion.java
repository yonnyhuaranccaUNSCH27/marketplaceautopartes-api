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
@Table(name = "tbl_detalleplansuscripcion")
public class Detalleplansuscripcion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idDetalleplansuscripcion;

    @ManyToOne
    @JoinColumn(name="idPlan", foreignKey = @ForeignKey(name="FK_DETALLEPLANSUSCRIPCION_PLAN"))
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "idPlansuscripcion", foreignKey = @ForeignKey(name="FK_DETALLEPLANSUSCRIPCION_PLANSUSCRIPCION"))
    private Plan plansuscripcion;
}
