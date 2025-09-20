package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Productocolor;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IProductocolorRepository;
import com.marketplaceautopartes.marketplaceapi.service.IProductocolorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductocolorServiceImpl extends CRUDImpl<Productocolor, Integer> implements IProductocolorService {

    private final IProductocolorRepository productocolorRepository;

    @Override
    protected IGenericRepo<Productocolor, Integer> getRepo() {
        return productocolorRepository;
    }
}

