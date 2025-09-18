package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.marketplaceautopartes.marketplaceapi.model.DetalleCompra;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Integer idVenta;

    private String serie;
    private String correlativo;
    private Double opgravada;
    private Double opinafecta;
    private Double opexonerada;
    private Double igv;
    private Double pago;
    private Double vuelto;
    private Double total;
    private LocalDateTime fechaemision;
    private LocalDateTime fechaestado;
    private LocalDateTime fechacodigoerror;
    private LocalDateTime fechamensajeserial;
    private String observacion;
    private String estado;
    private String orderNumber;
    private String transactionId;
    private String estadoTransaccion;
    private String codigoAutorizacion;

    @NotNull(message = "Es obligatorio")
    private Integer idTienda;

    @NotNull(message = "Es obligatorio")
    private Integer idTipocomprobante;

    @NotNull(message = "Es obligatorio")
    private Integer idCodigomoneda;

    @NotNull(message = "Es obligatorio")
    private Integer idFormapago;

    @NotNull(message = "Es obligatorio")
    private Integer idTipoventa;

    @JsonManagedReference
    private List<DetalleCompraDTO> detalleCompra;
}
