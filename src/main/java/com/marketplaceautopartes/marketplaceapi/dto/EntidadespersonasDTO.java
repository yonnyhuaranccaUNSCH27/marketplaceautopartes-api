package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntidadespersonasDTO {
    private Integer idEntidadespersonas;

    @NotBlank(message = "Es obligatorio")
    private String codigo;
    @NotBlank(message = "Es obligatorio")
    private String especialidad;
    private LocalDateTime fechacreada;
    @NotBlank(message = "Es obligatorio")
    private LocalDate fechaingreso;
    private LocalDate  fechasalida;
    private String tipocontrato;
    private String numconntrato;
    private String horariotrabajo;
    private Double salario;
    private String urlfirma;
    private String metas;
    private String observaciones;
    private Double bonificaciones;
    private Integer estado;
    private String disponibilidad;
    private Double tarifahora;


    private TiendaDTO tienda;
    private CargoDTO cargo;
    private PersonaDTO persona;
    private TipoentidadespersonasDTO tipoentidadespersonas;
    private OficinaDTO oficina;
    private NiveleducacionDTO niveleducacion;


}
