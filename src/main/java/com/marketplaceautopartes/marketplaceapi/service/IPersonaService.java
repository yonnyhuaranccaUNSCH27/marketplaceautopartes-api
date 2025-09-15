package com.marketplaceautopartes.marketplaceapi.service;

import com.marketplaceautopartes.marketplaceapi.model.Persona;

import java.util.List;

public interface IPersonaService extends ICRUD<Persona,Integer> {
    public List<Persona> getxmundoc(Integer tipodocumento, String numdocumento) ;

    Persona updateCorreoTelefono(Integer idPersona, String correo, String telefono);
}
