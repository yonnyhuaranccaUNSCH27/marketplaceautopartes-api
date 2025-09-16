package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Carroceria;
import com.marketplaceautopartes.marketplaceapi.repository.ICarroceriaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICarroceriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroceriaServiceImpl extends CRUDImpl<Carroceria,Integer> implements ICarroceriaService {
    private final ICarroceriaRepository CarroceriaRepository;

    @Override
    protected IGenericRepo<Carroceria, Integer> getRepo() {
        return CarroceriaRepository;
    }

}