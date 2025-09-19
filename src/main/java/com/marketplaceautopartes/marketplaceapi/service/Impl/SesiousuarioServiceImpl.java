package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Sesionusuario;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ISesionusuarioRepository;
import com.marketplaceautopartes.marketplaceapi.service.ISesionusuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesiousuarioServiceImpl extends CRUDImpl<Sesionusuario,Integer> implements ISesionusuarioService {
    private final ISesionusuarioRepository sesionusuarioRepository;

    @Override
    protected IGenericRepo<Sesionusuario,Integer> getRepo() {
        return sesionusuarioRepository;
    }
}
