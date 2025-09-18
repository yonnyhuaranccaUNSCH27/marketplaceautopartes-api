package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Movimientocliente;
import com.marketplaceautopartes.marketplaceapi.repository.IMovimientoclienteRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IMovimientoclienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovimientoclienteServiceImpl extends CRUDImpl<Movimientocliente, Integer> implements IMovimientoclienteService {
    private final IMovimientoclienteRepository movimientoclienteRepository;

    @Override
    protected IGenericRepo<Movimientocliente, Integer> getRepo() {
        return movimientoclienteRepository;
    }
}
