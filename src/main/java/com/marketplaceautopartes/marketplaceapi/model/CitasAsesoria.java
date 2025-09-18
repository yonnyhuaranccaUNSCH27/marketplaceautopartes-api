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
@Table(name = "tbl_citasasesoria")
public class CitasAsesoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idCitasAsesoria;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fcita;

    @Column(nullable = false)
    private Date horarioInicio;

    @Column(nullable = false)
    private Date horarioFinal;
}
