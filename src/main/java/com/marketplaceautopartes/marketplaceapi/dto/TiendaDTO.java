package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.marketplaceautopartes.marketplaceapi.model.Ubigeo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDTO {
  private Integer idTienda;

  private String codigo;

  private TipodocumentoDTO tipodocumento;

  @NotBlank
  private String numeroDocumento;

  @NotBlank
  private String razonSocial;
  @NotBlank
  private String nombreComercial;
  @NotNull
  private Ubigeo ubigeo;

  private String nombreDireccion;

  @NotBlank
  private String telefono1;

  private String telefono2;

  @NotBlank
  private String correo1;

  private String correo2;

  private LocalDate fechaCreacion;

  private LocalDate fechaModificacion;

  private String urlLogo;

  private String urlPortada;

  private String usuarioSol;

  private String claveSol;

  //Todo: preguntar si debe ir los 3 o solo el fileCertificado
  private byte[] fileCertificado;  // Almacena el contenido binario del .pfx
  private String nombreCertificado;  // Nombre del archivo (ej: "certificado")
  private String tipoCertificado;

  private String nombredominio;

  //TODO: preguntar por id plan suscripcion
  @NotBlank
  private String descripcion;

  @NotBlank
  private String mision;

  @NotBlank
  private String vision;

  private Boolean estado;

  private LocalDate fechaSuscripcion;
  @JsonManagedReference
  private List<CuentabancariaDTO> cuentabancarias;
  //TODO: preguntar por numero de cuenta e id banco
}
