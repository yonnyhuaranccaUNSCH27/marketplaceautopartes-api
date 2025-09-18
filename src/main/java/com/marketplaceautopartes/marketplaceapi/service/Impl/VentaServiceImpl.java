package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Venta;
import com.marketplaceautopartes.marketplaceapi.repository.IVentaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {
    private final IVentaRepository ventaRepository;

    @Override
    protected IGenericRepo<Venta, Integer> getRepo() {
        return ventaRepository;
    }
}
