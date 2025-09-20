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
@Table(name = "tbl_listaorigenproducto")
public class Listaorigenproducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idListaorigenproducto;

    @ManyToOne
    @JoinColumn(name = "id_producto",foreignKey = @ForeignKey(name = "FK_LISTAORIGENPRODUCTO_PRODUCTO"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_origen",foreignKey = @ForeignKey(name = "FK_LISTAORIGENPRODUCTO_ORIGEN"))
    private Origen origen;


}
