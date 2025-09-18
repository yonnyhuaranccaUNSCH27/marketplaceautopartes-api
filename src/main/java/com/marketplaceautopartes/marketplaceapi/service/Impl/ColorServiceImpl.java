package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Color;
import com.marketplaceautopartes.marketplaceapi.repository.IColorRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.IColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl extends CRUDImpl<Color,Integer> implements IColorService {
    private final IColorRepository ColorRepository;

    @Override
    protected IGenericRepo<Color, Integer> getRepo() {
        return ColorRepository;
    }

}