package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Archivo;
import com.marketplaceautopartes.marketplaceapi.repository.IArchivoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IArchivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArchivoServiceImpl extends CRUDImpl<Archivo, Integer> implements IArchivoService {
    private final IArchivoRepository archivoRepository;

    @Override
    protected IGenericRepo<Archivo, Integer> getRepo() {
        return archivoRepository;
    }
}
