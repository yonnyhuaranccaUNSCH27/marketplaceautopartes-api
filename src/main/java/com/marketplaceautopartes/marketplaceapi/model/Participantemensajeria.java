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
@Table(name = "tbl_participantemensajeria")
public class Participantemensajeria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idParticipantemensajeria;

    @ManyToOne
    @JoinColumn(name = "id_mensaje",foreignKey = @ForeignKey(name = "FK_PARTICIPANTEMENSAJERIA_MENSAJE"))
    private Mensaje mensaje;

    @ManyToOne
    @JoinColumn(name = "id_participante",foreignKey = @ForeignKey(name = "FK_PARTICIPANTEMENSAJERIA_PARTICIPANTE"))
    private Participante participante;

    private Integer tipoparticipante;

}
