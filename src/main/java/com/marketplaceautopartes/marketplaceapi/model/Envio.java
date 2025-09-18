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
@Table(name = "tbl_envio")
public class Envio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idEnvio;

    private String direccion;
    private Double costo;
    private Integer estado;

    @Column(nullable = false)
    private LocalDate fechaenvio;

    @Column(nullable = false)
    private LocalDate fechaentrega;
    private String codigo;
    private String codigosecreto;

//    @ManyToOne
//    @JoinColumn(name = "id_venta",foreignKey = @ForeignKey(name = "FK_ENVIO_VENTA"))
//    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_ENVIO_UBIGEO"))
    private Ubigeo ubigeo;
}
