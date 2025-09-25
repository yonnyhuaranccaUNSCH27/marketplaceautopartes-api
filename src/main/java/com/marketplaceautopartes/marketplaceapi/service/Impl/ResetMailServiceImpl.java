package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.ResetMail;
import com.marketplaceautopartes.marketplaceapi.repository.IResetMailRepository;
import com.marketplaceautopartes.marketplaceapi.service.IResetMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResetMailServiceImpl implements IResetMailService {
    private final IResetMailRepository repo;

    @Override
    public ResetMail findByRandom(String random){
        return repo.findByRandom(random);
    }

    @Override
    public void save(ResetMail resetMail) {
        repo.save(resetMail);
    }

    @Override
    public void delete(ResetMail resetMail) {
        repo.delete(resetMail);
    }
}
