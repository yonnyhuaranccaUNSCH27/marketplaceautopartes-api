package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPersona;

    @Column(nullable = false, length = 20)
    private String pernumdocumento;

    @Column(nullable = false, length = 80)
    private String pernombres;

    @Column(nullable = false, length = 40)
    private String apepaterno;

    @Column(nullable = false, length = 40)
    private String apematerna;

    private Integer pergenero;
    private Integer perestadocivil;

    @Column(length = 120)
    private String perdireccion;

    @Column(length = 20)
    private String pertelefono;

    @Column(length = 120)
    private String percorreo;
    private LocalDate perfechanacimiento;
    private Integer pervalidacorreo;
    private LocalDateTime perfechacrea;

    @Column(nullable = true, length = 10000)  // Esto define el tamaño máximo en la base de datos
    @Size(max = 10000, message = "La descripción no puede tener más de 1000 caracteres")
    private String urlfoto;

    @Column(length = 300)
    private String nombrecomercial;

    private String urllinkedin;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_PERSONA_UBIGEO"))
    private Ubigeo ubigeo;

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento",foreignKey = @ForeignKey(name = "FK_PERSONA_TIPODOCUMENTO"))
    private Tipodocumento tipodocumento;
}
