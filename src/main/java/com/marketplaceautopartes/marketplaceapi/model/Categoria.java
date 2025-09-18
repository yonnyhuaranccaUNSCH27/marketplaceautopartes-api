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
@Table(name = "tbl_categoria")
public class Categoria {
<<<<<<< HEAD
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idCategoria;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;


=======
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idCategoria;

  @Column(nullable = false)
  private String codigo;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String descripcion;
>>>>>>> c07a4443bff525c421e11b1ae8580df9168204b5
}
