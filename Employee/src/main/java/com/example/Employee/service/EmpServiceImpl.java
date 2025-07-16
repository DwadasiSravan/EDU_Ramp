package com.example.Employee.service;

import com.example.Employee.DTO.EmpDTO;
import com.example.Employee.model.EmpModel;
import com.example.Employee.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService{


    private EmpRepository empRepository;

    @Autowired
    public EmpServiceImpl(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public void createEmp(EmpModel emp) {
        empRepository.save(emp);
    }

    @Override
    public void patchEmp(Long id, EmpDTO updatedEmp) {
        empRepository.findById(id).ifPresent(existingEmp -> {
            if(updatedEmp.getEmpName() != null && !updatedEmp.getEmpName().isBlank()) existingEmp.setEmpName(updatedEmp.getEmpName());
            if(updatedEmp.getEmailId() != null && !updatedEmp.getEmailId().isBlank()) existingEmp.setEmailId(updatedEmp.getEmailId());
            if(updatedEmp.getDomain() != null && !updatedEmp.getDomain().isBlank()) existingEmp.setDomain(updatedEmp.getDomain());
            empRepository.save(existingEmp);
                });
    }

    @Override
    public Optional<EmpModel> getEmpById(Long id) {
        return empRepository.findById(id);
    }

    @Override
    public List<EmpModel> getAllEmp() {
        return empRepository.findAll();
    }

    @Override
    public void deleteEmpById(Long id) {
        empRepository.deleteById(id);
    }

    @Override
    public void updateEmpById(Long id, EmpModel updatedEmp) {
        empRepository.findById(id)
                .map(emp -> {
                   emp.setEmpName(updatedEmp.getEmpName());
                   emp.setEmailId(updatedEmp.getEmailId());
                   emp.setDomain(updatedEmp.getDomain());
                   return empRepository.save(emp);
                })
                .orElseGet(() -> {
                    return empRepository.save(updatedEmp);
                });
    }
}
