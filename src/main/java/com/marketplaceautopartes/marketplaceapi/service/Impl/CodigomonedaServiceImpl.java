package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Codigomoneda;
import com.marketplaceautopartes.marketplaceapi.repository.ICodigomonedaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICodigomonedaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodigomonedaServiceImpl extends CRUDImpl<Codigomoneda, Integer> implements ICodigomonedaService {
    private final ICodigomonedaRepository codigomonedaRepository;

    @Override
    protected IGenericRepo<Codigomoneda, Integer> getRepo() {
        return codigomonedaRepository;
    }
}
