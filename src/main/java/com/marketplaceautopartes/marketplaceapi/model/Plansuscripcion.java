package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tbl_plansuscripcion")
public class Plansuscripcion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idPlansuscripcion;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String serie;

    @Column(nullable = false)
    private String opGravadas;

    @Column(nullable = false)
    private String igv;

    @Column(nullable = false)
    private String pago;

    @Column(nullable = false)
    private Integer numeroOrden;

    @Column(nullable = false)
    private Date femision;

    @Column(nullable = false)
    private Date festado;

    @Column(nullable = false)
    private String observacion;

    @Column(nullable = false)
    private String codigoCorreo;

    @ManyToOne
    @JoinColumn(name = "idTienda", foreignKey = @ForeignKey(name = "FK_PLANSUSCRIPCION_TIENDA"))
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "idCodigomoneda",foreignKey = @ForeignKey(name = "FK_PLANSUSCRIPCION_CODIGOMONEDA"))
    private Codigomoneda codigomoneda;

    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey =@ForeignKey(name = "fk_plansuscripcion_usuario"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTipocomprobante",foreignKey = @ForeignKey(name = "fk_palnsuscripcion_tipocomprobante"))
    private Tipocomprobante tipocomprobante;

}
