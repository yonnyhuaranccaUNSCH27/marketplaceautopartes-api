package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Listaorigenproducto;
import com.marketplaceautopartes.marketplaceapi.repository.IListaorigenproductoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IListaorigenproductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListaorigenproductoServiceImpl extends CRUDImpl<Listaorigenproducto,Integer> implements IListaorigenproductoService {
    private final IListaorigenproductoRepository ListaorigenproductoRepository;

    @Override
    protected IGenericRepo<Listaorigenproducto, Integer> getRepo() {
        return ListaorigenproductoRepository;
    }

}