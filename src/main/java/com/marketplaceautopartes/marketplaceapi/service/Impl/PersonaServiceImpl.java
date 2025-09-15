package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Persona;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IPersonaRepository;
import com.marketplaceautopartes.marketplaceapi.service.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl extends CRUDImpl<Persona,Integer> implements IPersonaService {

    private final IPersonaRepository personaRepository;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return personaRepository;
    }

    @Override
    public List<Persona> getxmundoc(Integer tipodocumento, String numdocumento) {
        return  personaRepository.findAllNumdoc(tipodocumento,numdocumento);
    }

    @Override
    public Persona updateCorreoTelefono(Integer idPersona, String correo, String telefono) {
        Persona persona = personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        persona.setPercorreo(correo);
        persona.setPertelefono(telefono);

        return personaRepository.save(persona);
    }
}
