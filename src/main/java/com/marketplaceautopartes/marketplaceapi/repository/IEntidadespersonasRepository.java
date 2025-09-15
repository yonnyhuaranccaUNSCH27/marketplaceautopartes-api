package com.marketplaceautopartes.marketplaceapi.repository;
import com.marketplaceautopartes.marketplaceapi.model.Entidadespersonas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEntidadespersonasRepository extends IGenericRepo<Entidadespersonas,Integer>{
    @Query(value = "SELECT * FROM tbl_persona a WHERE a.num_documento =:numdocumento AND a.id_tipo_documento =:tipodocumento ;", nativeQuery = true)
    List<Entidadespersonas> findAllNumdoc(@Param("tipodocumento") Integer tipodocumento, @Param("numdocumento") String numdocumento);
}
