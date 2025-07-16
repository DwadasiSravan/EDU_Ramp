package com.example.Employee.controller;

import com.example.Employee.DTO.EmpDTO;
import com.example.Employee.model.EmpModel;
import com.example.Employee.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/emp")
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping
    public void createEmp(@Valid @RequestBody EmpModel employee ){
        empService.createEmp(employee);
    }

    @GetMapping
    public List<EmpModel> getAllEmp(){
        return empService.getAllEmp();
    }

    @GetMapping("/{id}")
    public Optional<EmpModel> getEmpByID(@PathVariable Long id){
        return empService.getEmpById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable Long id){
        empService.deleteEmpById(id);
    }

    @PutMapping("/{id}")
    public void updateEmpById(@PathVariable Long id, @RequestBody EmpModel emp){
        empService.updateEmpById(id, emp);
    }

   @PatchMapping("/{id}")
    public void patchEmp(@PathVariable Long id, @Valid @RequestBody EmpDTO emp){

        empService.patchEmp(id, emp);
    }
}
