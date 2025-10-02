package com.marketplaceautopartes.marketplaceapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;
import com.marketplaceautopartes.marketplaceapi.model.Rol;
import com.marketplaceautopartes.marketplaceapi.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;

    @NotBlank(message = "Es obligatorio")
    private String usernombres;

    @NotBlank(message = "Es obligatorio")
    private String username;

    @NotBlank(message = "Es obligatorio")
    private String password;

    @NotNull(message = "El campo ES obligatorio")
    private Integer isactive;

    @NotNull(message = "La fecha de creación es obligatoria")
    private LocalDateTime fechacreado;

    private LocalDateTime fechamodificado;

    private Integer termino1;

    private Integer termino2;

    @NotNull
    private EntidadespersonasDTO entidadespersonas;

//    @JsonIgnoreProperties("usuario")
    private List<RolDTO> roles;

}
