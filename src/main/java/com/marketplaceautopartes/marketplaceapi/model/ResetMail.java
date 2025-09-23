package com.marketplaceautopartes.marketplaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResetMail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idResetMail;

    @Column(nullable = false, unique = true)
    private String random;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario user;

    @Column(nullable = false)
    private LocalDateTime expiration;

    public void setExpiration(int minutes) {
        LocalDateTime now = LocalDateTime.now();
        this.expiration = now.plusMinutes(minutes);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expiration);
    }

}
