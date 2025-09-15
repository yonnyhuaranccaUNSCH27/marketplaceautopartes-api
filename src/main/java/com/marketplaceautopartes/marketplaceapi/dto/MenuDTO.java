package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Integer idMenu;

    @NotBlank(message = "Es obligatorio")
    private String icono;

    @NotBlank(message = "Es obligatorio")
    private String nombremenu;

    @NotBlank(message = "Es obligatorio")
    private String urlmenu;
}
