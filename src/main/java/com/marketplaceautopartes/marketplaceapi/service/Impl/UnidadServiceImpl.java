package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Unidad;
import com.marketplaceautopartes.marketplaceapi.repository.IUnidadRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IUnidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnidadServiceImpl extends CRUDImpl<Unidad, Integer> implements IUnidadService {
    private final IUnidadRepository unidadRepository;

    @Override
    protected IGenericRepo<Unidad, Integer> getRepo() {
        return unidadRepository;
    }
}
