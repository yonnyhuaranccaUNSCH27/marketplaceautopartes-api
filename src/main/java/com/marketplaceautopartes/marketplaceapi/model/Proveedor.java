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

    private String cuentaCci;
    private String cuentaNormal;

    @Column(nullable = false)
    private int tipoProveedor;

    @ManyToOne
    @JoinColumn(name = "idBanco", nullable = false, foreignKey = @ForeignKey(name = "FK_Proveedor_Banco"))
    private Banco banco;

    @OneToOne
    @JoinColumn(name = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_Proveedor_Persona"))
    private Persona persona;

}
