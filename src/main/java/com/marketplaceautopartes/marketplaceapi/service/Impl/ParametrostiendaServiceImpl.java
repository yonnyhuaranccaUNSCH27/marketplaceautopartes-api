package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Parametrostienda;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IParametrostiendaRepository;
import com.marketplaceautopartes.marketplaceapi.service.IParametrostiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParametrostiendaServiceImpl extends CRUDImpl<Parametrostienda,Integer> implements IParametrostiendaService {
    private final IParametrostiendaRepository ParametrostiendaRepository;

    @Override
    protected IGenericRepo<Parametrostienda, Integer> getRepo() {
        return ParametrostiendaRepository;
    }
}
