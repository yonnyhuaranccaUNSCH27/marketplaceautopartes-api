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
@Table(name = "tbl_tipoafectacio")
public class Tipoafectacion {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idTipoafectacio;

  @Column(nullable = false)
  private String codigo;
  
  @Column(nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private String nombreafectacion;
}
