package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Cursomarketing;
import com.marketplaceautopartes.marketplaceapi.repository.ICursomarketingRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICursomarketingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursomarketingServiceImpl extends CRUDImpl<Cursomarketing,Integer> implements ICursomarketingService {
    private final ICursomarketingRepository repository;

    @Override
    protected IGenericRepo<Cursomarketing,Integer> getRepo() {
        return repository;
    }
}
