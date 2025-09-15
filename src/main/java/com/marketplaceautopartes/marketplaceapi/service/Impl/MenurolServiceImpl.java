package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Menurol;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IMenurolRepository;
import com.marketplaceautopartes.marketplaceapi.service.IMenurolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenurolServiceImpl extends CRUDImpl<Menurol,Integer> implements IMenurolService {
    private final IMenurolRepository menurolRepository;

    @Override
    protected IGenericRepo<Menurol,Integer> getRepo() {return menurolRepository;}
}
