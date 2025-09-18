package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Canalrecepcion;
import com.marketplaceautopartes.marketplaceapi.repository.ICanalrecepcionRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICanalrecepcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CanalrecepcionServiceImpl extends CRUDImpl<Canalrecepcion,Integer> implements ICanalrecepcionService {
    private final ICanalrecepcionRepository CanalrecepcionRepository;

    @Override
    protected IGenericRepo<Canalrecepcion, Integer> getRepo() {
        return CanalrecepcionRepository;
    }

}