package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
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
@Table(name = "tbl_entidadespersonas")
public class Entidadespersonas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idEntidadespersonas;

    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String especialidad;
    private LocalDateTime fechacreada;
    @Column(nullable = false)
    private LocalDate fechaingreso;
    private LocalDate  fechasalida;
    private String tipocontrato;
    private String numconntrato;
    private String horariotrabajo;
    private Double salario;
    private String urlfirma;
    private String metas;
    private String observaciones;
    private Double bonificaciones;
    private Integer estado;
    private String disponibilidad;
    private Double tarifahora;

    @ManyToOne
    @JoinColumn(name = "id_tienda",foreignKey = @ForeignKey(name = "FK_ENTIDADESPERSONAS_TIENDA"), nullable = true)
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "id_cargo",foreignKey = @ForeignKey(name = "FK_ENTIDADESPERSONAS_CARGO"))
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "id_persona",foreignKey = @ForeignKey(name = "FK_ENTIDADESPERSONAS_PERSONA"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipoentidadespersonas", foreignKey = @ForeignKey(name = "FK_ENTIDADESPERSONAS_TIPOENTIDADESPERSONAS"))
    private Tipoentidadespersonas tipoentidadespersonas;

    @ManyToOne
    @JoinColumn(name = "id_oficina", foreignKey = @ForeignKey(name = "FK_ENTIDADESPERSONAS_OFICINA"))
    private Oficina oficina;

    @ManyToOne
    @JoinColumn(name = "id_niveleducacion", foreignKey = @ForeignKey(name = "FK_ENTIDADESPERSONAS_NIVELEDUCACION"))
    private Niveleducacion niveleducacion;


}
