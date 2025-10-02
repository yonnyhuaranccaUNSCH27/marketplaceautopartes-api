package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Mensaje;
import com.marketplaceautopartes.marketplaceapi.model.Participante;
import com.marketplaceautopartes.marketplaceapi.model.Tienda;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantemensajeriaDTO {
    private Integer idParticipantemensajeria;

    @NotBlank
    private Mensaje mensaje;

    @NotNull
    private Participante participante;

    @NotNull
    private Integer tipoparticipante;
}
