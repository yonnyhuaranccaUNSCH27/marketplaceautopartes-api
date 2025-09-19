package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Citasasesoria;
import com.marketplaceautopartes.marketplaceapi.repository.ICitasasesoriaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICitasasesoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitasasesoriaServiceImpl extends CRUDImpl<Citasasesoria,Integer> implements ICitasasesoriaService {
    private final ICitasasesoriaRepository CitasasesoriaRepository;

    @Override
    protected IGenericRepo<Citasasesoria, Integer> getRepo() {
        return CitasasesoriaRepository;
    }
}
