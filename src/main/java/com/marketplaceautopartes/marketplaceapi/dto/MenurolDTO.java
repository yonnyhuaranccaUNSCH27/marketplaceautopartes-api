package com.marketplaceautopartes.marketplaceapi.dto;

import com.marketplaceautopartes.marketplaceapi.model.Menu;
import com.marketplaceautopartes.marketplaceapi.model.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenurolDTO {
    private Integer idMenurol;
    @NotNull
    private MenuDTO menu;

    @NotNull
    private RolDTO rol;
}
