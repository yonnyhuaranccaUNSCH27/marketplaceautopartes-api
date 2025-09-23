package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IloginRepository extends IGenericRepo<Usuario,Integer>{
    @Query("FROM Usuario us WHERE us.username =:username ")
    Usuario checkUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario us SET us.password =:password WHERE us.username=:username")
    void changePassword(@Param("password") String password, @Param("username") String username);

}
