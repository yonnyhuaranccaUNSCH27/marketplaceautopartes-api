package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Cupon;
import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;
import com.marketplaceautopartes.marketplaceapi.model.Tienda;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientecuponDTO {
    private Integer idClientecupon;

    @NotNull
    private CuponDTO cupon;
    @NotNull
    private Entidadespersonas entidadespersonas;

    private LocalDate fechaUso;
    private Boolean usado;
}
