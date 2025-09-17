package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Banco;
import com.marketplaceautopartes.marketplaceapi.repository.IBancoRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IBancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BancoServiceImpl extends CRUDImpl<Banco, Integer> implements IBancoService {
    private final IBancoRepository bancoRepository;

    @Override
    protected IGenericRepo<Banco, Integer> getRepo() {
        return bancoRepository;
    }
}
