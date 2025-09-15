package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Niveleducacion;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.INiveleducacionRepository;
import com.marketplaceautopartes.marketplaceapi.service.INiveleducacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NiveleducacionServiceImpl extends CRUDImpl<Niveleducacion,Integer> implements INiveleducacionService {
    private final INiveleducacionRepository niveleducacionRepository;

    @Override
    protected IGenericRepo<Niveleducacion,Integer> getRepo() {return niveleducacionRepository;}
}
