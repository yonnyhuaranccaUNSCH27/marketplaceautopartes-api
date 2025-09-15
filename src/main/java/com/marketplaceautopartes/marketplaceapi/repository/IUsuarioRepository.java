package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.Usuario;

import java.util.Optional;


public interface IUsuarioRepository extends IGenericRepo<Usuario,Integer> {
    Usuario findOneByUsername(String username);
    Optional<Usuario> findByUsername(String username);
}
