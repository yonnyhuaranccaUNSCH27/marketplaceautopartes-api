package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_usuario")
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer idUsuario;

    @Column(nullable = false)
    private String usernombres;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer isactive;

    @Column(nullable = false)
    private LocalDateTime fechacreado;

    private LocalDateTime fechamodificado;

    private Integer termino1;

    private Integer termino2;

    @ManyToOne
    @JoinColumn(name = "id_entidadespersonas",foreignKey = @ForeignKey(name = "FK_USUARIO_ENTIDADESPERSONAS"))
    private Entidadespersonas entidadespersonas;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_usuariorol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
    )

    private List<Rol> roles;

    // Getter personalizado para Spring Security
    public String getPassword() {
        return password;
    }
}
