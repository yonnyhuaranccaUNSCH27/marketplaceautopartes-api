package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlansuscripcionDTO {
    private Integer idPlansuscripcion;

    @NotNull
    private String estado;

    @NotNull
    private String serie;

    @NotNull
    private String opGravadas;

    @NotNull
    private String igv;

    @NotNull
    private String numeroOrden;

    @NotNull
    private Date femision;

    @NotNull
    private Date festado;

    @NotNull
    private String observacion;

    @NotNull
    private String codigoCorreo;

    private TiendaDTO tienda;

    private CodigomonedaDTO codigomoneda;

}
