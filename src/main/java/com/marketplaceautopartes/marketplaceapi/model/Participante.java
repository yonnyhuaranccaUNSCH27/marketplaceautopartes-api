package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_participante")
public class Participante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idParticipante;

    @ManyToOne
    @JoinColumn(name = "id_entidadespersonas", nullable = true)
    private Entidadespersonas entidadespersonas;

    private String telefonosExterno;
    private String nombreExterno;
    private String correoExterno;
}
