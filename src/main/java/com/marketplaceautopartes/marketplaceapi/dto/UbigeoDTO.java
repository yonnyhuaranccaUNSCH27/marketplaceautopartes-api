package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoDTO {
    private Integer idUbigeo;

    @NotBlank(message = "Es obligatorio")
    private String ubipais;

    @NotBlank(message = "Es obligatorio")
    private String ubidpto;

    @NotBlank(message = "Es obligatorio")
    private String ubiprovincia;

    @NotBlank(message = "Es obligatorio")
    private String ubidiscrito;

    @NotBlank(message = "Es obligatorio")
    private String denominacion;

    private String longitud;

    private String latitud;

    private Integer poblacion;

    private String superficie;

    private Integer ubiestado;
}
