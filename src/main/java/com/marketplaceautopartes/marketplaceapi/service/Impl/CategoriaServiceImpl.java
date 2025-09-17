package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Categoria;
import com.marketplaceautopartes.marketplaceapi.repository.ICategoriaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl extends CRUDImpl<Categoria, Integer> implements ICategoriaService {
    private final ICategoriaRepository categoriaRepository;

    @Override
    protected IGenericRepo<Categoria, Integer> getRepo() {
        return categoriaRepository;
    }
}
