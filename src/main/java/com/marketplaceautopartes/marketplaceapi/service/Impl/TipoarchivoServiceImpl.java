package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipoarchivo;
import com.marketplaceautopartes.marketplaceapi.repository.ITipoarchivoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ITipoarchivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoarchivoServiceImpl extends CRUDImpl<Tipoarchivo, Integer> implements ITipoarchivoService {
    private final ITipoarchivoRepository tipoarchivoRepository;

    @Override
    protected IGenericRepo<Tipoarchivo, Integer> getRepo() {
        return tipoarchivoRepository;
    }
}
