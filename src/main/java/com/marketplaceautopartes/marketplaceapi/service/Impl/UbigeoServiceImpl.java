package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Ubigeo;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IUbigeoRepository;
import com.marketplaceautopartes.marketplaceapi.service.IUbigeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl extends CRUDImpl<Ubigeo,Integer> implements IUbigeoService {

    private final IUbigeoRepository ubigeoRepository;

    @Override
    protected IGenericRepo<Ubigeo,Integer> getRepo() {return ubigeoRepository;}


    @Override
    public List<Ubigeo> getDepartments(){
        return ubigeoRepository.findAllDepartaments();
    }

    @Override
    public List<Ubigeo> getProviciasByDepartment(String departaments){
        return ubigeoRepository.findAllProvinciasByDepartaments(departaments);
    }

    @Override
    public List<Ubigeo> getDistritos(String departaments,String provincias){
        return ubigeoRepository.findAllDistritosByProvinciaByDistrito(departaments,provincias);
    }
}
