package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_sesionusuario")
public class Sesionusuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idSesionusuario;

    @Column(nullable = false)
    private String tokensesion;

    @Column(nullable = false)
    private Date finicio;

    @Column(nullable = false)
    private Date fexpiracion;

    @Column(nullable = false)
    private String isactive;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_SESIONUSUARIO_USUARIO"))
    private Usuario usuario;


}
