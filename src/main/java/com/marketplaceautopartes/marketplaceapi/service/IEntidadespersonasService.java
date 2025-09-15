package com.marketplaceautopartes.marketplaceapi.service;

import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;

import java.util.List;

public interface IEntidadespersonasService extends ICRUD<Entidadespersonas,Integer> {
    public List<Entidadespersonas> getxmundoc(Integer tipodocumento, String numdocumento) ;

}
