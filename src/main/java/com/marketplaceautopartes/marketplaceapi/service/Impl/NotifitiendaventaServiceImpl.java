package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Notifitiendaventa;
import com.marketplaceautopartes.marketplaceapi.repository.INotifitiendaventaRepository;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.INotifitiendaventaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifitiendaventaServiceImpl extends CRUDImpl<Notifitiendaventa,Integer> implements INotifitiendaventaService {
    private final INotifitiendaventaRepository NotifitiendaventaRepository;

    @Override
    protected IGenericRepo<Notifitiendaventa, Integer> getRepo() {
        return NotifitiendaventaRepository;
    }

}