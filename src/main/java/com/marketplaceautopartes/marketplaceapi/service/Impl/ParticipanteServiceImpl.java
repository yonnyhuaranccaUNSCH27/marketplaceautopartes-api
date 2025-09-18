package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Participante;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IParticipanteRepository;
import com.marketplaceautopartes.marketplaceapi.service.IParticipanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipanteServiceImpl extends CRUDImpl<Participante,Integer> implements IParticipanteService {
    private final IParticipanteRepository participanteRepository;

    @Override
    protected IGenericRepo<Participante, Integer> getRepo() {
        return participanteRepository;
    }

}