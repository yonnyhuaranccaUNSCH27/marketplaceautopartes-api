package com.marketplaceautopartes.marketplaceapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SesionusuarioDTO {
    private Integer idSesionusuario;

    @NotBlank(message = "el token de sesion oblig")
    private String tokensesion;

    @Column(nullable = false)
    private Date finicio;

    @Column(nullable = false)
    private Date fexpiracion;

    @Column(nullable = false)
    private String isactive;

    private UsuarioDTO usuario;


}
