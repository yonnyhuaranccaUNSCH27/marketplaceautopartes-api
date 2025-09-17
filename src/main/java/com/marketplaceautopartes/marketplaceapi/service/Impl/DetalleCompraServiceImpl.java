package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.DetalleCompra;
import com.marketplaceautopartes.marketplaceapi.repository.IDetalleCompraRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IDetalleCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleCompraServiceImpl extends CRUDImpl<DetalleCompra, Integer> implements IDetalleCompraService {
    private final IDetalleCompraRepository detalleCompraRepository;

    @Override
    protected IGenericRepo<DetalleCompra, Integer> getRepo() {
        return detalleCompraRepository;
    }
}
