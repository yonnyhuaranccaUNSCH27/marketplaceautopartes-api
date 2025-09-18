package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Ventaestadohistorial;
import com.marketplaceautopartes.marketplaceapi.repository.IVentaestadohistorialRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IVentaestadohistorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaestadohistorialServiceImpl extends CRUDImpl<Ventaestadohistorial,Integer> implements IVentaestadohistorialService {
    private final IVentaestadohistorialRepository ventaestadohistorialRepository;

    @Override
    protected IGenericRepo<Ventaestadohistorial, Integer> getRepo() {
        return ventaestadohistorialRepository;
    }

}