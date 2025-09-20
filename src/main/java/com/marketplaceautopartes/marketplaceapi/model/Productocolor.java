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
@Table(name = "tbl_productocolor")
public class Productocolor {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idProductocolor;

  @ManyToOne
  @JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_productocolor_producto"))
  private Producto producto;

  @ManyToOne
  @JoinColumn(name = "idColor", nullable = false, foreignKey = @ForeignKey(name = "FK_productocolor_color"))
  private Color color;
}
