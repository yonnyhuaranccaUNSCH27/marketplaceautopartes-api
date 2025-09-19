package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Personacitasasesoria;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IPersonacitasasesoriaRepository;
import com.marketplaceautopartes.marketplaceapi.service.IPersonacitasasesoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonacitasasesoriaServiceImpl extends CRUDImpl<Personacitasasesoria,Integer> implements IPersonacitasasesoriaService {
    private final IPersonacitasasesoriaRepository PersonacitasasesoriaRepository;

    @Override
    protected IGenericRepo<Personacitasasesoria, Integer> getRepo() {
        return PersonacitasasesoriaRepository;
    }
}
