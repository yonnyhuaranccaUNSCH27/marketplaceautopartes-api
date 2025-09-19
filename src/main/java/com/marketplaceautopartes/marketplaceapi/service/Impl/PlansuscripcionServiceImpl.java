package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Plansuscripcion;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IPlansuscripcionRepository;
import com.marketplaceautopartes.marketplaceapi.service.IPlansuscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlansuscripcionServiceImpl extends CRUDImpl<Plansuscripcion,Integer> implements IPlansuscripcionService {
    private final IPlansuscripcionRepository plansuscripcionRepository;

    @Override
    protected IGenericRepo<Plansuscripcion,Integer> getRepo() {
        return plansuscripcionRepository;
    }
}
