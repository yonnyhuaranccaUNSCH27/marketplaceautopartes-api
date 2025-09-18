package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipocomprobante;
import com.marketplaceautopartes.marketplaceapi.repository.ITipocomprobanteRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ITipocomprobanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipocomprobanteServiceImpl extends CRUDImpl<Tipocomprobante, Integer> implements ITipocomprobanteService {
    private final ITipocomprobanteRepository tipocomprobanteRepository;

    @Override
    protected IGenericRepo<Tipocomprobante, Integer> getRepo() {
        return tipocomprobanteRepository;
    }
}
