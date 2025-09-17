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
@Table(name = "tbl_impresora")
public class Impresora {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idImpresora;

    @Column(nullable = false)
    private String nombreimpresora;

    private String nombrecompartido;
    private String tipopuerto;
    private String ipconexion;
    private String nombremaquina;
    private String passwordmaquina;
}
