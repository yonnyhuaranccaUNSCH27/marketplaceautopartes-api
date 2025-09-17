package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Compra;
import com.marketplaceautopartes.marketplaceapi.repository.ICompraRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl extends CRUDImpl<Compra, Integer> implements ICompraService {
    private final ICompraRepository compraRepository;

    @Override
    protected IGenericRepo<Compra, Integer> getRepo() {
        return compraRepository;
    }
}
