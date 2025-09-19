package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Subdominio;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ISubdominioRepository;
import com.marketplaceautopartes.marketplaceapi.service.ISubdominioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubdominioServiceImpl extends CRUDImpl<Subdominio,Integer> implements ISubdominioService {
    private final ISubdominioRepository subdominioRepository;

    @Override
    protected IGenericRepo<Subdominio, Integer> getRepo() {
        return subdominioRepository;
    }
}
