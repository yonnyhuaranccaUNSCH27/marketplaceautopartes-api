package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeDTO {
    private Integer idMensaje;

    @NotBlank
    private String asunto;

    private Integer estado;

    //TODO:preguntar para que es esto
    private String codigo;

    private LocalDateTime fechaCreacion;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String tipoServicio;

}
