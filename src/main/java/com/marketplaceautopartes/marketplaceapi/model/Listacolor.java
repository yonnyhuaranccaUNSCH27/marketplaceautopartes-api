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
@Table(name = "tbl_listacolor")
public class Listacolor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idListacolor;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo",foreignKey = @ForeignKey(name = "FK_LISTACOLOR_VEHICULO"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_color",foreignKey = @ForeignKey(name = "FK_LISTACOLOR_COLOR"))
    private Color color;
}
