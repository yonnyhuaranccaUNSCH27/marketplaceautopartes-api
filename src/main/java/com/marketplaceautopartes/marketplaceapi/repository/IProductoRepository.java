package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends IGenericRepo<Producto, Integer> {
}
