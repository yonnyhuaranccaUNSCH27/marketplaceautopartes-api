package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tienda;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ITiendaRepository;
import com.marketplaceautopartes.marketplaceapi.service.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TiendaServiceImpl extends CRUDImpl<Tienda,Integer> implements ITiendaService {

    private final ITiendaRepository tiendaRepository;

    @Override
    protected IGenericRepo<Tienda,Integer> getRepo() {return tiendaRepository;}
}
