package com.marketplaceautopartes.marketplaceapi.service.Impl;


import com.marketplaceautopartes.marketplaceapi.model.Tipooficina;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ITipooficinaRepository;
import com.marketplaceautopartes.marketplaceapi.service.ITipooficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipooficinaServiceImpl extends CRUDImpl<Tipooficina,Integer> implements ITipooficinaService {
    private final ITipooficinaRepository tipooficinaRepository;

    @Override
    protected IGenericRepo<Tipooficina, Integer> getRepo() {return tipooficinaRepository;}

}
