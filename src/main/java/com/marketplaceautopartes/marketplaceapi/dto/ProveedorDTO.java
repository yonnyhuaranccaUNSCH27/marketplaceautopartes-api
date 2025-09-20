package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private Integer idProveedor;


    @NotNull(message = "Es obligatorio")
    private int tipoProveedor;


    private CuentabancariaDTO cuentabancaria;

    @NotNull(message = "Es obligatorio")
    private PersonaDTO persona;
}
