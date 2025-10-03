package com.marketplaceautopartes.marketplaceapi.service;


import com.marketplaceautopartes.marketplaceapi.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu,Integer>{

    public List<Menu> getMenuByRolUsername(Integer id_rol, Integer id_usuario);
}
