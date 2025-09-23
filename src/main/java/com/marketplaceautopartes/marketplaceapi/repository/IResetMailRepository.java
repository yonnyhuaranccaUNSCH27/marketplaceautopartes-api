package com.marketplaceautopartes.marketplaceapi.repository;

import com.marketplaceautopartes.marketplaceapi.model.ResetMail;

public interface IResetMailRepository extends IGenericRepo<ResetMail,Integer>{
    //FROM ResetMail rm WHERE rm.random=?
    ResetMail findByRandom(String random);
}
