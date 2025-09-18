package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tiposervicio;
import com.marketplaceautopartes.marketplaceapi.repository.ITiposervicioRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ITiposervicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TiposervicioServiceImpl extends CRUDImpl<Tiposervicio, Integer> implements ITiposervicioService {
    private final ITiposervicioRepository tiposervicioRepository;

    @Override
    protected IGenericRepo<Tiposervicio, Integer> getRepo() {
        return tiposervicioRepository;
    }
}
