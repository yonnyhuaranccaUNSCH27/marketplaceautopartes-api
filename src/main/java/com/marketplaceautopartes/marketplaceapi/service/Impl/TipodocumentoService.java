package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipodocumento;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ITipodocumentoRepository;
import com.marketplaceautopartes.marketplaceapi.service.ITipodocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipodocumentoService extends CRUDImpl<Tipodocumento,Integer> implements ITipodocumentoService {

    private final ITipodocumentoRepository tipodocumentoRepository;

    @Override
    protected IGenericRepo<Tipodocumento, Integer> getRepo() {
        return tipodocumentoRepository;
    }

}
