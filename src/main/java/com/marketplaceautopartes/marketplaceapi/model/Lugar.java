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
@Table(name = "tbl_lugar")
public class Lugar {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idLugar;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "idImpresora", foreignKey = @ForeignKey(name = "FK_lugar_impresora"))
  private Impresora impresora;
}
