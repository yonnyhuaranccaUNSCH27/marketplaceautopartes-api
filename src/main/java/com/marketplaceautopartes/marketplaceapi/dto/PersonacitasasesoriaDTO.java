package com.marketplaceautopartes.marketplaceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonacitasasesoriaDTO {
    private Integer idPersonacitasasesoria;

    private CitasasesoriaDTO citasasesoria;
}
