package com.example.Employee.repository;

import com.example.Employee.model.EmpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<EmpModel, Long> {

}
