package com.telecom.plan_service.service;

import com.telecom.plan_service.dto.PlanDTO;
import com.telecom.plan_service.model.Plan;
import com.telecom.plan_service.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Optional<Plan> getPlanById(Long id) {
        return planRepository.findById(id);
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public void updatePlan(Long id, PlanDTO planDTO) {
        planRepository.findById(id).ifPresent(plan -> {
            if(planDTO.getName() != null && !planDTO.getName().isBlank()) plan.setName(planDTO.getName());
            if(planDTO.getType() != null && !planDTO.getType().isBlank()) plan.setType(planDTO.getType());
            if(planDTO.getValidity() != null && !planDTO.getValidity().isBlank()) plan.setValidity(planDTO.getValidity());
            if(planDTO.getPrice() != null && !planDTO.getPrice().isNaN()) plan.setPrice(planDTO.getPrice());
            planRepository.save(plan);
        });
    }

    @Override
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}
