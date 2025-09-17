package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Producto;
import com.marketplaceautopartes.marketplaceapi.repository.IProductoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {
    private final IProductoRepository productoRepository;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return productoRepository;
    }
}
