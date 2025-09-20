package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Categoria;
import com.marketplaceautopartes.marketplaceapi.model.Cupon;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuponcategoriaDTO {
    private Integer idCuponcategoria;

    @NotNull
    private Cupon cupon;

    @NotNull
    private Categoria categoria;
}
