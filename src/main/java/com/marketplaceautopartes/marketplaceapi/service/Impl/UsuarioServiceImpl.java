package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Usuario;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IUsuarioRepository;
import com.marketplaceautopartes.marketplaceapi.service.IUsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl extends CRUDImpl<Usuario,Integer> implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    @Override
    protected IGenericRepo<Usuario,Integer> getRepo() {return usuarioRepository;}

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElse(null);
    }




}
