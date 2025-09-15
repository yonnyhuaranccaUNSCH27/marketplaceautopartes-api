package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Oficina;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IOficinaRepository;
import com.marketplaceautopartes.marketplaceapi.service.IOficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OficinaServiceImpl extends CRUDImpl<Oficina,Integer> implements IOficinaService {

    private final IOficinaRepository oficinaRepository;

    @Override
    protected IGenericRepo<Oficina,Integer> getRepo() {return oficinaRepository;}
}
