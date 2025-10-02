package com.marketplaceautopartes.marketplaceapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {
  private Integer idSerie;
  private String tipoComprobante;
  private String serie;
  private Integer correlativo;
  private Integer idTienda;
}
