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
@Table(name = "tbl_historialconsultas")
public class Historialconsultas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idHistorialconsultas;

    @Column(nullable = false)
    private String descripcion;

//    @ManyToOne
//    @JoinColumn(name = "id_marca",foreignKey = @ForeignKey(name = "FK_HISTORIALCONSULTAS_MARCA"))
//    private Marca marca;



}
