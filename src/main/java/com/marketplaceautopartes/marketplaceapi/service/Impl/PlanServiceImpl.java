package com.marketplaceautopartes.marketplaceapi.service.Impl;

import com.marketplaceautopartes.marketplaceapi.model.Plan;
import com.marketplaceautopartes.marketplaceapi.repository.IGenericRepo;
import com.marketplaceautopartes.marketplaceapi.repository.IPlanRepository;
import com.marketplaceautopartes.marketplaceapi.service.IPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl extends CRUDImpl<Plan,Integer> implements IPlanService {
    private final IPlanRepository planRepository;

    @Override
    protected IGenericRepo<Plan, Integer> getRepo() {
        return planRepository;
    }

}
