package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Listacolor;
import com.marketplaceautopartes.marketplaceapi.repository.IListacolorRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IListacolorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListacolorServiceImpl extends CRUDImpl<Listacolor,Integer> implements IListacolorService {
    private final IListacolorRepository ListacolorRepository;

    @Override
    protected IGenericRepo<Listacolor, Integer> getRepo() {
        return ListacolorRepository;
    }

}