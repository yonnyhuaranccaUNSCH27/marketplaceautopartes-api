package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.marketplaceautopartes.marketplaceapi.model.Listacolor;
import com.marketplaceautopartes.marketplaceapi.model.Listatipocombustible;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Integer idVehiculo;

    private String numeroplaca;

    @NotNull
    private LocalDate fechainscripcion;

    @NotNull
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

    private MarcaDTO marca;
    private ClasevehiculoDTO clasevehiculo;
    private CarroceriaDTO carroceria;
    private ModeloDTO modelo;

    @JsonManagedReference
    private List<Listatipocombustible> listatipocombustible;

    @JsonManagedReference
    private List<Listacolor> listacolor;
}
