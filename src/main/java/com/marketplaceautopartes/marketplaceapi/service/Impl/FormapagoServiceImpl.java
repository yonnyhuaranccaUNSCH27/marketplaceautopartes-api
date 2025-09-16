package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Formapago;
import com.marketplaceautopartes.marketplaceapi.repository.IFormapagoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IFormapagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormapagoServiceImpl extends CRUDImpl<Formapago,Integer> implements IFormapagoService {
    private final IFormapagoRepository FormapagoRepository;

    @Override
    protected IGenericRepo<Formapago, Integer> getRepo() {
        return FormapagoRepository;
    }

}