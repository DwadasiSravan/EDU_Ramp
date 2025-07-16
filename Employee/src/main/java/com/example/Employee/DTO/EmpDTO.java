package com.example.Employee.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpDTO {
    private Long id;
    private String empName;
    private String emailId;
    private String domain;

}
