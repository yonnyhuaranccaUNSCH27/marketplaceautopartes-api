package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentabancariaDTO {
    private Integer idCuentabancaria;

    @NotBlank(message = "El número de cuenta es obligatorio")
    private String numeroCuenta;

    @NotBlank(message = "El tipo de cuenta es obligatorio")
    private String tipoCuenta;

    @NotNull(message = "El banco es obligatorio")
    private BancoDTO banco;

    @NotNull(message = "El código de moneda es obligatorio")
    private CodigomonedaDTO codigomoneda;

    @JsonBackReference
    private TiendaDTO tienda;
}
