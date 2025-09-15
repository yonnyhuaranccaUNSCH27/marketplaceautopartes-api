package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Rol;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IRolRepository;
import com.marketplaceautopartes.marketplaceapi.service.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolServiceImpl extends CRUDImpl<Rol,Integer> implements IRolService {

    private final IRolRepository rolRepository;

    @Override
    protected IGenericRepo<Rol,Integer> getRepo() {return rolRepository;}
}
