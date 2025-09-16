package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipocombustible;
import com.marketplaceautopartes.marketplaceapi.repository.ITipocombustibleRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ITipocombustibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipocombustibleServiceImpl extends CRUDImpl<Tipocombustible,Integer> implements ITipocombustibleService {
    private final ITipocombustibleRepository TipocombustibleRepository;

    @Override
    protected IGenericRepo<Tipocombustible, Integer> getRepo() {
        return TipocombustibleRepository;
    }

}