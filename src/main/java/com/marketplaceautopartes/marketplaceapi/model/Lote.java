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
@Table(name = "tbl_lote")
public class Lote {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idLote;

  private String numLote;
  private LocalDateTime fechaLLegada;
  private int cantidad;
  private Double costoUnitario;

  @ManyToOne
  @JoinColumn(name = "id_producto", nullable = false)
  private Producto producto;
}
