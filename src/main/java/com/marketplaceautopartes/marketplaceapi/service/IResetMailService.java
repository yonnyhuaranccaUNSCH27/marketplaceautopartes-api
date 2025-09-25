package com.marketplaceautopartes.marketplaceapi.service;

import com.marketplaceautopartes.marketplaceapi.model.ResetMail;

public interface IResetMailService {
    ResetMail findByRandom(String random);
    void save(ResetMail resetMail);
    void delete(ResetMail resetMail);

}
