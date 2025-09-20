package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.marketplaceautopartes.marketplaceapi.model.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private TiposervicioDTO tiposervicio;

    private CategoriaDTO categoria;

    private MarcaDTO marca;

    private UnidadDTO unidad;

    private TipoafectacionDTO tipoafectacion;

    private LugarDTO lugar;

    private TiendaDTO tienda;

    private UbigeoDTO ubigeo;

    @JsonManagedReference
    private List<ListaorigenproductoDTO> listaorigenproducto;
}
