package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Serie;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.ISerieRepository;
import com.marketplaceautopartes.marketplaceapi.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl extends CRUDImpl<Serie, Integer> implements ISerieService {
    private final ISerieRepository serieRepository;

    @Override
    protected IGenericRepo<Serie, Integer> getRepo() {
        return serieRepository;
    }
}
