package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Clasevehiculo;
import com.marketplaceautopartes.marketplaceapi.repository.IClasevehiculoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IClasevehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClasevehiculoServiceImpl extends CRUDImpl<Clasevehiculo,Integer> implements IClasevehiculoService {
    private final IClasevehiculoRepository ClasevehiculoRepository;

    @Override
    protected IGenericRepo<Clasevehiculo, Integer> getRepo() {
        return ClasevehiculoRepository;
    }

}