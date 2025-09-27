package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Participantemensajeria;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IParticipantemensajeriaRepository;
import com.marketplaceautopartes.marketplaceapi.service.IParticipantemensajeriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantemensajeriaServiceImpl extends CRUDImpl<Participantemensajeria,Integer> implements IParticipantemensajeriaService {
    private final IParticipantemensajeriaRepository participanteRepository;

    @Override
    protected IGenericRepo<Participantemensajeria, Integer> getRepo() {
        return participanteRepository;
    }

}