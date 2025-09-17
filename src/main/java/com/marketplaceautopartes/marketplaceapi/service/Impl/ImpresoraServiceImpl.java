package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Impresora;
import com.marketplaceautopartes.marketplaceapi.repository.IImpresoraRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IImpresoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImpresoraServiceImpl extends CRUDImpl<Impresora, Integer> implements IImpresoraService {
    private final IImpresoraRepository impresoraRepository;

    @Override
    protected IGenericRepo<Impresora, Integer> getRepo() {
        return impresoraRepository;
    }
}
