package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_venta")
public class Venta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
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

    @ManyToOne
    @JoinColumn(name = "idTienda", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_tienda"))
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "idTipocomprobante", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_tipocomprobante"))
    private Tipocomprobante tipocomprobante;

    @ManyToOne
    @JoinColumn(name = "idCodigomoneda", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_codigomoneda"))
    private Codigomoneda codigomoneda;

    @ManyToOne
    @JoinColumn(name = "idFormapago", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_formapago"))
    private Formapago Formapago;

    @ManyToOne
    @JoinColumn(name = "idTipoventa", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_tipoventa"))
    private Tipoventa tipoventa;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listaventa> listaventas;

}
