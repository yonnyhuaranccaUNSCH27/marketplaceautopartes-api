package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoteDTO {
    private Integer idLote;
    private String numLote;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaLLegada;
    private int cantidad;
    private Double costoUnitario;
    private ProductoDTO producto;
}
