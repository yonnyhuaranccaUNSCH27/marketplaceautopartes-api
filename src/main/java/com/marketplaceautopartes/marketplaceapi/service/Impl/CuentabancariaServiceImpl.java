package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Cuentabancaria;
import com.marketplaceautopartes.marketplaceapi.repository.ICuentabancariaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICuentabancariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuentabancariaServiceImpl extends CRUDImpl<Cuentabancaria, Integer> implements ICuentabancariaService {
    private final ICuentabancariaRepository cuentabancariaRepository;

    @Override
    protected IGenericRepo<Cuentabancaria, Integer> getRepo() {
        return cuentabancariaRepository;
    }
}
