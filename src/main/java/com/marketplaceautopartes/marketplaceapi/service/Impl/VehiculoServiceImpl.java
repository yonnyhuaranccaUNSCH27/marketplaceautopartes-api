package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Vehiculo;
import com.marketplaceautopartes.marketplaceapi.repository.IVehiculoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl extends CRUDImpl<Vehiculo,Integer> implements IVehiculoService {
    private final IVehiculoRepository VehiculoRepository;

    @Override
    protected IGenericRepo<Vehiculo, Integer> getRepo() {
        return VehiculoRepository;
    }

}