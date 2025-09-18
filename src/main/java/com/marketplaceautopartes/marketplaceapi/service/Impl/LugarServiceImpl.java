package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Lugar;
import com.marketplaceautopartes.marketplaceapi.repository.ILugarRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ILugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LugarServiceImpl extends CRUDImpl<Lugar, Integer> implements ILugarService {
    private final ILugarRepository lugarRepository;

    @Override
    protected IGenericRepo<Lugar, Integer> getRepo() {
        return lugarRepository;
    }
}
