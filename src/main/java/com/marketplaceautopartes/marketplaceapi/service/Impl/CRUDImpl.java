package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.exception.ModelNotFoundException;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.service.ICRUD;
import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t){
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t){
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("El ID no debe ser NULL" + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("el ID no de debe ser NULL"+id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("el ID no de debe ser NULL"+id));
        getRepo().deleteById(id);
    }


}
