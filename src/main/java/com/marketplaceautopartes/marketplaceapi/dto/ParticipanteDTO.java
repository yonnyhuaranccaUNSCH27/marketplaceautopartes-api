package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteDTO {
    private Integer idParticipante;
    private EntidadespersonasDTO entidadespersonas;
    private String telefonosExterno;
    private String nombreExterno;
    private String correoExterno;
}
