package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Integer idProducto;

    private String codigo;
    private String codigointernacional;
    private String codigobarras;

    @NotBlank(message = "Es obligatorio")
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
    private String modelo;

    @NotNull(message = "Es obligatorio")
    private Integer idTiposervicio;

    @NotNull(message = "Es obligatorio")
    private Integer idCategoria;

    @NotNull(message = "Es obligatorio")
    private Integer idMarca;
    private Integer idUnidad;
    private Integer idTipoafectacion;
    private Integer idLugar;
    private Integer idOrigen;
    @NotNull(message = "Es obligatorio")
    private Integer idTienda;
    private Integer idUbigeo;
}
