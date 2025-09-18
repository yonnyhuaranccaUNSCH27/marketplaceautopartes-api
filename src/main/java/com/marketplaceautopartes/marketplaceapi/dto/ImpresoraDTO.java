package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImpresoraDTO {
    private Integer idImpresora;

    @NotBlank(message = "Es obligatorio")
    private String nombreimpresora;

    private String nombrecompartido;
    private String tipopuerto;
    private String ipconexion;
    private String nombremaquina;
    private String passwordmaquina;
}
