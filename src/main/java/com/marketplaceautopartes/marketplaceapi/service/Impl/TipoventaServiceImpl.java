package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipoventa;
import com.marketplaceautopartes.marketplaceapi.repository.ITipoventaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ITipoventaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoventaServiceImpl extends CRUDImpl<Tipoventa,Integer> implements ITipoventaService {
    private final ITipoventaRepository TipoventaRepository;

    @Override
    protected IGenericRepo<Tipoventa, Integer> getRepo() {
        return TipoventaRepository;
    }

}