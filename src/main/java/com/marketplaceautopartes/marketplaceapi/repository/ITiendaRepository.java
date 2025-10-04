package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.Tienda;

public interface ITiendaRepository extends IGenericRepo<Tienda,Integer> {

  public Tienda findTiendaByIdTienda(Integer idTienda);
}
