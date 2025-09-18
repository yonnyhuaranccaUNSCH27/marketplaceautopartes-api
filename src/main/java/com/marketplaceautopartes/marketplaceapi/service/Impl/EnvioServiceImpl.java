package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Envio;
import com.marketplaceautopartes.marketplaceapi.repository.IEnvioRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IEnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnvioServiceImpl extends CRUDImpl<Envio,Integer> implements IEnvioService {
    private final IEnvioRepository EnvioRepository;

    @Override
    protected IGenericRepo<Envio, Integer> getRepo() {
        return EnvioRepository;
    }

}