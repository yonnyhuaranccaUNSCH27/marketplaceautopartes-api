package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends IGenericRepo<Categoria, Integer> {
}
