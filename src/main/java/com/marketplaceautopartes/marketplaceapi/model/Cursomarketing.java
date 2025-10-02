package com.marketplaceautopartes.marketplaceapi.model;

import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_cursomarketing")
public class Cursomarketing {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idCursomarketing;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false,name = "online, oofline, ausente,ocupado")
    private String tipo;

    @Column(nullable = false)
    private String duracion;

    @Column(nullable = false)
    private String urlvideo;

    @ManyToOne
    @JoinColumn(name = "idPersona",nullable = false,foreignKey = @ForeignKey(name = "fk_cursomarketing_persona"))
    private Persona persona;
}
