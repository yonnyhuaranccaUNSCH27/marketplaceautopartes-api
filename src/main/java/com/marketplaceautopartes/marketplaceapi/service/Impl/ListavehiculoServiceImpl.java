package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Listavehiculo;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IListavehiculoRepository;
import com.marketplaceautopartes.marketplaceapi.service.IListavehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListavehiculoServiceImpl extends CRUDImpl<Listavehiculo,Integer> implements IListavehiculoService {
    private final IListavehiculoRepository ListavehiculoRepository;

    @Override
    protected IGenericRepo<Listavehiculo, Integer> getRepo() {
        return ListavehiculoRepository;
    }

}