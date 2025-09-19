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
@Table(name ="tbl_subdominio" )
public class Subdominio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idSubdominio;

    @Column(nullable = false)
    private String estadoverificacion;

    @Column(nullable = false)
    private String valorparametro;

    @Column(nullable = false)
    private Date fregistro;

    @Column(nullable = false)
    private Date fverifiacion;

    @ManyToOne
    @JoinColumn(name = "idTienda", nullable = false,foreignKey = @ForeignKey(name="fk_subdominio_tienda"))
    private Tienda tienda;



}
