package com.example.Employee.service;

import com.example.Employee.DTO.EmpDTO;
import com.example.Employee.model.EmpModel;

import java.util.List;
import java.util.Optional;

public interface EmpService {
    void createEmp(EmpModel emp);

    List<EmpModel> getAllEmp();

    void deleteEmpById(Long id);

    void updateEmpById(Long id, EmpModel emp);

    Optional<EmpModel> getEmpById(Long id);

    void patchEmp(Long id, EmpDTO emp);
}
