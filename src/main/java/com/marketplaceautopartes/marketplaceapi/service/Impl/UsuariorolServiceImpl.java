package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Usuariorol;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IUsuariorolRepository;
import com.marketplaceautopartes.marketplaceapi.service.IUsuariorolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuariorolServiceImpl extends CRUDImpl<Usuariorol,Integer> implements IUsuariorolService {
    private final IUsuariorolRepository usuariorolRepository;

    @Override
    protected IGenericRepo<Usuariorol,Integer> getRepo() {return usuariorolRepository;}
}
