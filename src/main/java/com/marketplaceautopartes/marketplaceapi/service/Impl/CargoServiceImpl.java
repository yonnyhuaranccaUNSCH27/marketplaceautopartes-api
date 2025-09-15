package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Cargo;
import com.marketplaceautopartes.marketplaceapi.repository.ICargoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl extends CRUDImpl<Cargo,Integer> implements ICargoService {
    private final ICargoRepository CargoRepository;

    @Override
    protected IGenericRepo<Cargo, Integer> getRepo() {
        return CargoRepository;
    }

}