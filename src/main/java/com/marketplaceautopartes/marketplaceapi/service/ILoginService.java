package com.marketplaceautopartes.marketplaceapi.service;

import com.marketplaceautopartes.marketplaceapi.model.Usuario;

public interface ILoginService {
    Usuario checkUsername(String username);
    void changePassword( String password, String username);

}
