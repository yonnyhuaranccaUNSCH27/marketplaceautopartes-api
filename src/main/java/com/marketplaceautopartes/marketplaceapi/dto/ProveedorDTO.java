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

    private String cuentaCci;
    private String cuentaNormal;

    @NotNull(message = "Es obligatorio")
    private int tipoProveedor;

    @NotNull(message = "Es obligatorio")
    private Integer idBanco;

    @NotNull(message = "Es obligatorio")
    private Integer idPersona;
}
