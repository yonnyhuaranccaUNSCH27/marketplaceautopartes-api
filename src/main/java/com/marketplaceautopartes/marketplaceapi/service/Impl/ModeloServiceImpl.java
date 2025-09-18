package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Modelo;
import com.marketplaceautopartes.marketplaceapi.repository.IModeloRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl extends CRUDImpl<Modelo,Integer> implements IModeloService {
    private final IModeloRepository ModeloRepository;

    @Override
    protected IGenericRepo<Modelo, Integer> getRepo() {
        return ModeloRepository;
    }

}