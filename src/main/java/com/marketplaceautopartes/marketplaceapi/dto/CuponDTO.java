package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Tienda;
import jakarta.persistence.Column;
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
public class CuponDTO {
    private Integer idCupon;
    @NotBlank
    private String nombre;
    @NotNull
    private Integer tipoDescuento; // "porcentaje" o "fijo"
    @Positive
    private Integer valorDescuento; // valor del descuento
    @FutureOrPresent
    private LocalDate fechaInicio;
    @Future
    private LocalDate fechaFin;
    private Boolean activo;
    private LocalDate fechaCreacion;
    @NotNull
    private Tienda tienda;
    private String codigo;
    @NotBlank
    private String descripcion;
}
