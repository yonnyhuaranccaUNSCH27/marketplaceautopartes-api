package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Cupon;
import com.marketplaceautopartes.marketplaceapi.repository.ICuponRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICuponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuponServiceImpl extends CRUDImpl<Cupon,Integer> implements ICuponService {
    private final ICuponRepository cuponRepository;

    @Override
    protected IGenericRepo<Cupon, Integer> getRepo() {
        return cuponRepository;
    }

}