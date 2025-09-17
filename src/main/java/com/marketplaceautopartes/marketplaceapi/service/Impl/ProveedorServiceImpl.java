package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Proveedor;
import com.marketplaceautopartes.marketplaceapi.repository.IProveedorRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl extends CRUDImpl<Proveedor, Integer> implements IProveedorService {
    private final IProveedorRepository proveedorRepository;

    @Override
    protected IGenericRepo<Proveedor, Integer> getRepo() {
        return proveedorRepository;
    }
}
