package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubdominioDTO {
    private Integer idSubdominio;

    @NotNull
    private String estadoVerificacion;

    @NotNull
    private String valorparametro;

    @NotNull
    private Date fregistro;

    @NotNull
    private Date fverificacion;

    private TiendaDTO tienda;
}
