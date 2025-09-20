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
@Table(name = "tbl_clientecupon")
public class Clientecupon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idClientecupon;

    @ManyToOne
    @JoinColumn(name = "id_cupon", nullable = false)
    private Cupon cupon;

    @ManyToOne
    @JoinColumn(name = "id_entidadespersona", nullable = false)
    private Entidadespersonas entidadespersonas;

    private LocalDate fechaUso;
    private Boolean usado;
}
