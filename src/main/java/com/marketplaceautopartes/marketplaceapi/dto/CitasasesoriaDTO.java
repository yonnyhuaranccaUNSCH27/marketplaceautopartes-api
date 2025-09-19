package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitasasesoriaDTO {
    private Integer idCitasasesoria;

    @Column(nullable = false,length = 40)
    private String descripcion;

    @Column(nullable = false)
    private Date fcita;

    @Column(nullable = false)
    private Date horarioInicio;

    @Column(nullable = false)
    private Date horarioFinal;


}
