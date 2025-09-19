package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Listabeneficios;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IListabeneficiosRepository;
import com.marketplaceautopartes.marketplaceapi.service.IListabeneficiosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListabeneficiosServiceImpl extends CRUDImpl<Listabeneficios,Integer> implements IListabeneficiosService {
    private final IListabeneficiosRepository ListabeneficiosRepository;

    @Override
    protected IGenericRepo<Listabeneficios, Integer> getRepo() {
        return ListabeneficiosRepository;
    }
}
