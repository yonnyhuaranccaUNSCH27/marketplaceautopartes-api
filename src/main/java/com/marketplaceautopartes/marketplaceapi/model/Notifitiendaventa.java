package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_notifitiendaventa")
public class Notifitiendaventa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idNotifitiendaventa;

    private String descripcion;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fechaenvio;

    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_ventaestadohistorial",foreignKey = @ForeignKey(name = "FK_NOTIFICACIONVENTA_VENTAESTADOHISTORIAL"))
    private Ventaestadohistorial ventaestadohistorial;

}
