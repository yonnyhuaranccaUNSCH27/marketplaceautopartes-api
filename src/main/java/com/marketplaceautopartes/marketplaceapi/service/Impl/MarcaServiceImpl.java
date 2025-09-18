package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Marca;
import com.marketplaceautopartes.marketplaceapi.repository.IMarcaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IMarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl extends CRUDImpl<Marca,Integer> implements IMarcaService {
    private final IMarcaRepository MarcaRepository;

    @Override
    protected IGenericRepo<Marca, Integer> getRepo() {
        return MarcaRepository;
    }

}