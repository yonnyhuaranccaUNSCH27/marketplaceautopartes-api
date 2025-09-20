package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Clientecupon;
import com.marketplaceautopartes.marketplaceapi.repository.IClientecuponRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IClientecuponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientecuponServiceImpl extends CRUDImpl<Clientecupon,Integer> implements IClientecuponService {
    private final IClientecuponRepository clientecuponRepository;

    @Override
    protected IGenericRepo<Clientecupon, Integer> getRepo() {
        return clientecuponRepository;
    }

}