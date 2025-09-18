package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Resenia;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IReseniaRepository;
import com.marketplaceautopartes.marketplaceapi.service.IReseniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReseniaServiceImpl extends CRUDImpl<Resenia,Integer> implements IReseniaService {
    private final IReseniaRepository reseniaRepository;

    @Override
    protected IGenericRepo<Resenia, Integer> getRepo() {
        return reseniaRepository;
    }

}