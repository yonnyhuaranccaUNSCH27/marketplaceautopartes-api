package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Menugrupo;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IMenugrupoRepository;
import com.marketplaceautopartes.marketplaceapi.service.IMenugrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenugrupoServiceImpl extends CRUDImpl<Menugrupo,Integer> implements IMenugrupoService {

    private final IMenugrupoRepository menugrupoRepository;

    @Override
    protected IGenericRepo<Menugrupo,Integer> getRepo() {return menugrupoRepository;}
}
