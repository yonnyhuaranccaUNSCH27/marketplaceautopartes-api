package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private Integer idCompra;
    private Double total;
    private Double igv;
    private LocalDateTime fechaEntrega;
    private String numGuia;
    private String placaVehiculo;
    private LocalDateTime fechaEmision;
    private String observacion;
    private String estadoGuia;
    private String origen;
    private String destino;

    @NotNull(message = "Es obligatorio")
    private ProveedorDTO proveedor;

    @NotNull(message = "Es obligatorio")
    private UsuarioDTO usuario;
    @JsonManagedReference
    private List<DetalleCompraDTO> detalleCompra;
}
