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
@Table(name = "tbl_personacitasasesoria")
public class Personascitasasesoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idPersonascitasasesoria;

//    @ManyToOne
//    @JoinColumn(name=idCitasasesoria, nullable = false, foreignKey = @ForeignKey(name = "FK_PERSONASCITASASESORIA_CITASASESORIA"))
//    private CitasAsesoria citasAsesoria;

//    @ManyToOne
//    @JoinColumn(name=idComponentepersona, nullable = false,foreignKey = @ForeignKey(name = "fk_personascitasasesoria_componentepersona"))
//    private ComponentePersona componentePersona;

}
