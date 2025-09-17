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
@Table(name = "tbl_archivo")
public class Archivo {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idArchivo;

  @Column(nullable = false)
  private String urll;

  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "idTipoarchivo", nullable = false, foreignKey = @ForeignKey(name = "FK_archivo_tipoarchivo"))
  private Tipoarchivo tipoarchivo;

  @ManyToOne
  @JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_archivo_producto"))
  private Producto producto;
}
