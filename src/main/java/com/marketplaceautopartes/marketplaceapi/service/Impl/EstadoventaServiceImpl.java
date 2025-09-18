package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Estadoventa;
import com.marketplaceautopartes.marketplaceapi.repository.IEstadoventaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IEstadoventaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstadoventaServiceImpl extends CRUDImpl<Estadoventa,Integer> implements IEstadoventaService {
    private final IEstadoventaRepository estadoVentaRepository;

    @Override
    protected IGenericRepo<Estadoventa, Integer> getRepo() {
        return estadoVentaRepository;
    }

}