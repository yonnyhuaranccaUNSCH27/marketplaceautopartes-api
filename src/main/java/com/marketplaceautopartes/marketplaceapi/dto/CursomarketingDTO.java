package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursomarketingDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idCursomarketing;

    @NotNull
    private String titulo;

    @NotNull
    private String descripcion;

    @NotNull
    private String tipo;

    @NotNull
    private String duracion;

    @NotNull
    private String urlvideo;

    private PersonaDTO persona;
}
