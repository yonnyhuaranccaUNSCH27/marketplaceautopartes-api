package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Listatipocombustible;
import com.marketplaceautopartes.marketplaceapi.repository.IListatipocombustibleRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IListatipocombustibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListatipocombustibleServiceImpl extends CRUDImpl<Listatipocombustible,Integer> implements IListatipocombustibleService {
    private final IListatipocombustibleRepository ListatipocombustibleRepository;

    @Override
    protected IGenericRepo<Listatipocombustible, Integer> getRepo() {
        return ListatipocombustibleRepository;
    }

}