package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Rol;
import com.marketplaceautopartes.marketplaceapi.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariorolDTO {

    private Integer idUsuariorol;


    private RolDTO rol;

    private UsuarioDTO usuario;
}
