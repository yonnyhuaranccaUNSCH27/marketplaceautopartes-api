package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifitiendaventaDTO {
    private Integer idNotifitiendaventa;

    private String descripcion;

    @NotNull
    private String asunto;

    @NotNull
    private String mensaje;

    @NotNull
    private LocalDateTime fechaenvio;

    private Integer estado;

//    private VentaestadohistorialDTO ventaestadohistorial;
}
