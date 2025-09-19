package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialconsultasDTO {
    private Integer idHistorialconsultas;

    @NotNull
    private String descripcion;

    private MarcaDTO marca;

    private CategoriaDTO categoria;

    private TiendaDTO tienda;

//    private ComponentepersonaDTO componenetepersona;
}
