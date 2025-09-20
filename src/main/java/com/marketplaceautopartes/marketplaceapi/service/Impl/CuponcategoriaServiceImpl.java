package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Cuponcategoria;
import com.marketplaceautopartes.marketplaceapi.repository.ICuponcategoriaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICuponcategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuponcategoriaServiceImpl extends CRUDImpl<Cuponcategoria,Integer> implements ICuponcategoriaService {
    private final ICuponcategoriaRepository cuponcategoriaRepository;

    @Override
    protected IGenericRepo<Cuponcategoria, Integer> getRepo() {
        return cuponcategoriaRepository;
    }

}