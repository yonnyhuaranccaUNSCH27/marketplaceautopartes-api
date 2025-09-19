package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Historialconsultas;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IHistorialconsultasRepository;
import com.marketplaceautopartes.marketplaceapi.service.IHistorialconsultasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistorialconsultasServiceImpl extends CRUDImpl<Historialconsultas,Integer> implements IHistorialconsultasService {
    private final IHistorialconsultasRepository HistorialconsultasRepository;

    @Override
    protected IGenericRepo<Historialconsultas, Integer> getRepo() {
        return HistorialconsultasRepository;
    }
}
