package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametrostiendaDTO {
    private Integer idParametrostienda;

    @NotNull
    private String descripcion;

    @NotNull
    private String claveparametro;

    @NotNull
    private String valorparametro;

    @NotNull
    private Integer stockminimo;

    @NotNull
    private Date fcreacion;

    @NotNull
    private Date factualizacion;

    private TiendaDTO tienda;


}
