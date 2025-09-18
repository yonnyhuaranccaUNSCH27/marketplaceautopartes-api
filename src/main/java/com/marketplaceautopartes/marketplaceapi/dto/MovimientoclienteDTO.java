package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoclienteDTO {
    private Integer idMovimientocliente;

    private LocalDateTime fechaCreada;
    private Double totalcompra;
    private String preferenciapaga;

    private EntidadespersonasDTO entidadespersonas;

    private VentaDTO venta;
}
