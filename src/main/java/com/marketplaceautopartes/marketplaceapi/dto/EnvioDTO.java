package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDTO {
    private Integer idEnvio;

    private String direccion;
    private Double costo;
    private Integer estado;

    @NotNull
    private LocalDate fechaenvio;

    @NotNull
    private LocalDate fechaentrega;
    private String codigo;
    private String codigosecreto;

//    private VentaDTO venta;
    private UbigeoDTO ubigeo;
}
