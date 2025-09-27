package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeadjuntoDTO {
    private Integer idMensajeadjunto;

    @NotBlank
    private String nombre;

    @NotBlank
    private String contenido;

    private MensajeDTO mensaje;

}
