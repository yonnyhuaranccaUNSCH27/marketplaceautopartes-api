package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_producto")
public class Producto {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @EqualsAndHashCode.Include
  private Integer idProducto;

  private String codigo;
  private String codigointernacional;
  private String codigobarras;

  @Column(nullable = false)
  private String nombre;

  private String nombregenerico;
  private Double pactivo;
  private Double igv;
  private Integer stockunitario;
  private Integer stockmin;
  private Double preciocostocaja;
  private Double precioventacaja;
  private Double preciocupon;
  private Integer unidadCaja;
  private Integer stockcaja;
  private Double preciocostounidad;
  private Double precioventa1;
  private Double precioventa2;
  private Double precioventa3;
  private LocalDateTime fechasalida;
  private LocalDateTime fechacreada;
  private int estado;
  private String observacion;
  private int totalvisitas;
  private int totalcompartidos;
  //Agregados
  private String modelo;

  @ManyToOne
  @JoinColumn(name = "idTiposervicio", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Tiposervicio"))
  private Tiposervicio tiposervicio;

  @ManyToOne
  @JoinColumn(name = "idCategoria", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Categoria"))
  private Categoria categoria;


  @ManyToOne
  @JoinColumn(name = "idMarca", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Marca"))
  private Marca marca;

  @ManyToOne
  @JoinColumn(name = "idUnidad", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Unidad"))
  private Unidad unidad;

  @ManyToOne
  @JoinColumn(name = "idTipoacfectacion", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Tipoafectacion"))
  private Tipoafectacion tipoafectacion;

  @ManyToOne
  @JoinColumn(name = "idLugar", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Lugar"))
  private Lugar lugar;

  @ManyToOne
  @JoinColumn(name = "idTienda", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Tienda"))
  private Tienda tienda;

  @ManyToOne
  @JoinColumn(name = "idUbigeo", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Ubigeo"))
  private Ubigeo ubigeo;

  @OneToMany(mappedBy = "producto")
  private java.util.List<Productocolor> productocolor;
}
