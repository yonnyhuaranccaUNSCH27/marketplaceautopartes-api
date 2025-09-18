package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaDTO {
    private Integer idResenia;

    private LocalDate fechaResena;
    @NotBlank
    private String contenido;
    @Min(value = 1)
    @Max(value = 5)
    private Integer calificacion;

    @NotBlank
    private String asunto;
    @NotNull
    private ProductoDTO producto;
    @NotNull
    private EntidadespersonasDTO entidadespersonas;
}
