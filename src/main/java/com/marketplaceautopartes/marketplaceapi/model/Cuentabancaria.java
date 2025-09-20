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
@Table(name = "tbl_cuentabancaria")
public class Cuentabancaria {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idCuentabancaria;

 private String numeroCuenta;
  private String tipoCuenta;

  @ManyToOne
  @JoinColumn(name = "idBanco", nullable = false, foreignKey = @ForeignKey(name = "FK_CuentaBanco_Banco"))
  private Banco banco;

@ManyToOne
  @JoinColumn(name = "idCodigomoneda", nullable = false, foreignKey = @ForeignKey(name = "FK_CuentaBanco_CodigoMoneda"))
  private Codigomoneda codigomoneda;

@ManyToOne
  @JoinColumn(name = "idTienda", nullable = false, foreignKey = @ForeignKey(name = "FK_CuentaBanco_Tienda"))
  private Tienda tienda;
}
