package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Mensaje;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IMensajeRepository;
import com.marketplaceautopartes.marketplaceapi.service.IMensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeServiceImpl extends CRUDImpl<Mensaje,Integer> implements IMensajeService {
    private final IMensajeRepository mensajeRepository;

    @Override
    protected IGenericRepo<Mensaje, Integer> getRepo() {
        return mensajeRepository;
    }

}