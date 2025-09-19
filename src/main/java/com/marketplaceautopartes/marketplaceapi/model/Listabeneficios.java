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
@Table(name = "tbl_listabeneficios")
public class Listabeneficios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idListabeneficios;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="id_plan", foreignKey = @ForeignKey(name = "FK_LISTABENEFICIOS_PLAN"))
    private Plan plan;



}
