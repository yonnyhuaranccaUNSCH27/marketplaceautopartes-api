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
@Table(name = "tbl_proveedor")
public class Proveedor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idProveedor;

    @Column(nullable = false)
    private int tipoProveedor;

    @ManyToOne
    @JoinColumn(name = "idCuentabancaria", nullable = false, foreignKey = @ForeignKey(name = "FK_Proveedor_CuentaBancaria"))
    private Cuentabancaria cuentabancaria;

    @OneToOne
    @JoinColumn(name = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_Proveedor_Persona"))
    private Persona persona;

}
