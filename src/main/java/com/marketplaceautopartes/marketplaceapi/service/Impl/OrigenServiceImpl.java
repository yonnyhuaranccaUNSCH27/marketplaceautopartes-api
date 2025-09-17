package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Origen;
import com.marketplaceautopartes.marketplaceapi.repository.IOrigenRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IOrigenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrigenServiceImpl extends CRUDImpl<Origen, Integer> implements IOrigenService {
    private final IOrigenRepository origenRepository;

    @Override
    protected IGenericRepo<Origen, Integer> getRepo() {
        return origenRepository;
    }
}
