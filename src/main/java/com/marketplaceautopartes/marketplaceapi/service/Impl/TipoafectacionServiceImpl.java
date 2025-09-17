package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipoafectacion;
import com.marketplaceautopartes.marketplaceapi.repository.ITipoafectacionRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ITipoafectacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoafectacionServiceImpl extends CRUDImpl<Tipoafectacion, Integer> implements ITipoafectacionService {
    private final ITipoafectacionRepository tipoafectacionRepository;

    @Override
    protected IGenericRepo<Tipoafectacion, Integer> getRepo() {
        return tipoafectacionRepository;
    }
}
