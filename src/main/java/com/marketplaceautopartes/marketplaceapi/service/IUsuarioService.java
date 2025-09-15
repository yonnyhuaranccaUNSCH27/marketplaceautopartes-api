package com.marketplaceautopartes.marketplaceapi.service;

import com.marketplaceautopartes.marketplaceapi.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario,Integer> {
    Usuario findByUsername(String username);
}
