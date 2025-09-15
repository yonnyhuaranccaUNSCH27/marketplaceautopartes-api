package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Tipodocumento;
import com.marketplaceautopartes.marketplaceapi.model.Ubigeo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Integer idPersona;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(max = 20, message = "El número de documento no puede tener más de 20 caracteres")
    private String pernumdocumento;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80, message = "El nombre no puede tener más de 80 caracteres")
    private String pernombres;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 40, message = "El apellido paterno no puede tener más de 40 caracteres")
    private String apepaterno;

    @Column(nullable = false, length = 40)
    private String apematerna;

    @NotNull(message = "El campo género es obligatorio")
    private Integer pergenero;

    @Size(max = 120, message = "La dirección no puede tener más de 120 caracteres")
    private Integer perestadocivil;

    @Size(max = 120)
    private String perdireccion;

    @Size(max = 20)
    private String pertelefono;

    @Size(max = 120)
    private String percorreo;
    private LocalDate perfechanacimiento;
    private Integer pervalidacorreo;
    private LocalDateTime perfechacrea;

    @Size(max = 10000, message = "La URL de la foto no puede tener más de 10000 caracteres")
    private String urlfoto;

    @Size(max = 300, message = "El nombre comercial no puede tener más de 300 caracteres")
    private String nombrecomercial;

    @Size(max = 500, message = "La URL de LinkedIn no puede tener más de 500 caracteres")
    private String urllinkedin;

    private UbigeoDTO ubigeo;

    private TipodocumentoDTO tipodocumento;
}
