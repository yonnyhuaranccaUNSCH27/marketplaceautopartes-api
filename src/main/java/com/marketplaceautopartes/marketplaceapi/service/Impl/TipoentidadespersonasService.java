package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Tipoentidadespersonas;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ITipoentidadespersonasRepository;
import com.marketplaceautopartes.marketplaceapi.service.ITipoentidadespersonasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoentidadespersonasService extends CRUDImpl<Tipoentidadespersonas,Integer> implements ITipoentidadespersonasService {

    private final ITipoentidadespersonasRepository tipoentidadespersonasRepository;

    @Override
    protected IGenericRepo<Tipoentidadespersonas, Integer> getRepo() {
        return tipoentidadespersonasRepository;
    }

}
