package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;
import com.marketplaceautopartes.marketplaceapi.repository.IEntidadespersonasRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IEntidadespersonasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntidadespersonasServiceImpl extends CRUDImpl<Entidadespersonas,Integer> implements IEntidadespersonasService {
    private final IEntidadespersonasRepository entidadespersonasRepository;

    @Override
    protected IGenericRepo<Entidadespersonas, Integer> getRepo() {
        return entidadespersonasRepository;
    }

    @Override
    public List<Entidadespersonas> getxmundoc(Integer tipodocumento, String numdocumento) {
        return  entidadespersonasRepository.findAllNumdoc(tipodocumento,numdocumento);
    }

}