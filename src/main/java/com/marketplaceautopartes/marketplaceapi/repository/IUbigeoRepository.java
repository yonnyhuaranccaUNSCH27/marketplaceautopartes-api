package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.Ubigeo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUbigeoRepository extends IGenericRepo<Ubigeo,Integer> {
    //@Transactional
    //@Modifying para agregar, actuaizar y eliminar
    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubidistrito='00' AND u.ubi_provincia='00'",nativeQuery = true)
    List<Ubigeo> findAllDepartaments();

    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubidpto=:departaments AND u.ubidistrito='00' AND u.ubiprovincia!='00'",nativeQuery = true)
    List<Ubigeo> findAllProvinciasByDepartaments(@Param("departaments") String departaments);

    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubidpto=:departaments  AND u.ubiprovincia=:provincias AND u.ubidistrito!='00';",nativeQuery = true)
    List<Ubigeo> findAllDistritosByProvinciaByDistrito(@Param("departaments") String departaments,@Param("provincias") String provincias);
}
