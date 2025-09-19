package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Detalleplansuscripcion;
import com.marketplaceautopartes.marketplaceapi.repository.IDetalleplansuscripcionRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICRUD;
import com.marketplaceautopartes.marketplaceapi.service.IDetalleplansuscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleplansuscripcionServiceImpl extends CRUDImpl<Detalleplansuscripcion,Integer> implements IDetalleplansuscripcionService {
    private final IDetalleplansuscripcionRepository detalleplansuscripcionRepository;

    @Override
    protected IGenericRepo<Detalleplansuscripcion, Integer> getRepo() {
        return detalleplansuscripcionRepository;
    }
}
