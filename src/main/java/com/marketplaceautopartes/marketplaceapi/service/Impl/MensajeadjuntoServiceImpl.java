package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Mensajeadjunto;
import com.marketplaceautopartes.marketplaceapi.repository.IMensajeadjuntoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IMensajeadjuntoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeadjuntoServiceImpl extends CRUDImpl<Mensajeadjunto,Integer> implements IMensajeadjuntoService {
    private final IMensajeadjuntoRepository mensajeadjuntoRepository;

    @Override
    protected IGenericRepo<Mensajeadjunto, Integer> getRepo() {
        return mensajeadjuntoRepository;
    }

}