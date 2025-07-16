package com.example.Employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.DataAmount;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name shouldn't be empty.")
    @Size(max = 50, message = "Employee name is too large!!!!")
    private String empName;

    @Email(message = "Please enter the correct Email.")
    private String emailId;

    @NotBlank(message = "Domain cannot be blank")
    @Size(max = 10, message = "Domain name is too Large!!!")
    private String domain;
}
