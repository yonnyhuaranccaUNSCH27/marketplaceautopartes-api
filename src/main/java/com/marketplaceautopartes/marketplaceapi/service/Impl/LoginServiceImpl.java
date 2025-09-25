package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Usuario;
import com.marketplaceautopartes.marketplaceapi.repository.IloginRepository;
import com.marketplaceautopartes.marketplaceapi.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService {
    private final IloginRepository repo;
    private final PasswordEncoder bccrypt;

    @Override
    public Usuario checkUsername(String username) {
        return repo.checkUsername(username);
    }

    @Override
    public void changePassword(String username, String password) {
        repo.changePassword(bccrypt.encode(password),username);
    }

}
