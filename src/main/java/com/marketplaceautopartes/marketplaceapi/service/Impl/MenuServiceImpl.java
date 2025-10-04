package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Menu;
import com.marketplaceautopartes.marketplaceapi.model.Ubigeo;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IMenuRepository;
import com.marketplaceautopartes.marketplaceapi.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends CRUDImpl<Menu,Integer> implements IMenuService {

    private final IMenuRepository menuRepository;

    @Override
    protected IGenericRepo<Menu,Integer> getRepo() {return menuRepository;}

    @Override
    public List<Menu> getMenuByRolUsername(Integer id_rol, Integer id_usuario){
        return menuRepository.getMenuByRolUsername(id_rol,id_usuario);
    }
}
