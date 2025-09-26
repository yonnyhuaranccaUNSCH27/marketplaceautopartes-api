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
@Table(name = "tbl_resenia")
public class Resenia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idResenia;

    @Column(nullable = false)
    private LocalDate fechaResenia;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    private Integer calificacion;

    @Column(nullable = false)
    private String asunto;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_entidadespersonas")
    private Entidadespersonas entidadespersonas;

    @PrePersist
    public void prePersist() {
        fechaResenia = LocalDate.now();
    }
}
