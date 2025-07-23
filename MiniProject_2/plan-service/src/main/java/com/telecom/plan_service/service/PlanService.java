package com.telecom.plan_service.service;


import com.telecom.plan_service.dto.PlanDTO;
import com.telecom.plan_service.model.Plan;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    Plan createPlan(Plan plan);
    Optional<Plan> getPlanById(Long id);
    List<Plan> getAllPlans();
    void updatePlan(Long id, PlanDTO planDTO);
    void deletePlan(Long id);
}
