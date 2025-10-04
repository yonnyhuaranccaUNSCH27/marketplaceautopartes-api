package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_tienda")
public class Tienda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idTienda;

    @Column(nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento", nullable = false)
    private Tipodocumento tipodocumento;

    @Column(nullable = false)
    private String numeroDocumento;

    @Column(nullable = false)
    private String razonSocial;

    @Column(nullable = false)
    private String nombreComercial;

    @OneToOne
    @JoinColumn(name = "id_ubigeo", nullable = false)
    private Ubigeo ubigeo;

    @Column(nullable = false)
    private String nombreDireccion;

    @Column(nullable = false)
    private String telefono1;

    private String telefono2;

    @Column(nullable = false)
    private String correo1;

    private String correo2;

    private LocalDate fechaCreacion;

    private LocalDate fechaModificacion;

    private String urlLogo;

    private String urlPortada;

    private String usuarioSol;

    private String claveSol;

    //Todo: preguntar si debe ir los 3 o solo el fileCertificado
  @Lob
  @Column(name = "file_certificado", columnDefinition = "VARBINARY(MAX)")
  private byte[] fileCertificado;
  @Column(name = "nombre_certificado", length = 255)
  private String nombreCertificado;
  @Column(name = "tipo_certificado", length = 100)
  private String tipoCertificado;

    private String nombredominio;

    //TODO: preguntar por id plan suscripcion
    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String mision;

    @Column(nullable = false)
    private String vision;

    private Boolean estado;

    private LocalDate fechaSuscripcion;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuentabancaria> cuentasBancarias;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDate.now();
        this.estado = true;
    }
}
