package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_vehiculo")
public class Vehiculo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idVehiculo;

    private String numeroplaca;

    @Column(nullable = false)
    private LocalDate fechainscripcion;

    @Column(nullable = false)
    private String anofabricacion;
    private String motor;
    private String chasis;
    private String placaantigua;
    private Integer asientos;
    private String ejes;
    private String ruedas;
    private String pesoneto;
    private String pesoseco;
    private String cargautil;
    private String largo;
    private String ancho;
    private String alto;
    private String antiguedad;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_marca",foreignKey = @ForeignKey(name = "FK_VEHICULO_MARCA"))
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_clasevehiculo",foreignKey = @ForeignKey(name = "FK_VEHICULO_CLASEVEHICULO"))
    private Clasevehiculo clasevehiculo;

    @ManyToOne
    @JoinColumn(name = "id_carroceria",foreignKey = @ForeignKey(name = "FK_VEHICULO_CARROCERIA"))
    private Carroceria carroceria;

    @ManyToOne
    @JoinColumn(name = "id_modelo",foreignKey = @ForeignKey(name = "FK_VEHICULO_MODELO"))
    private Modelo modelo;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listatipocombustible> listatipocombustible;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listacolor> listacolor;
}
