package com.internship.ems.dto;

import com.internship.ems.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  departmentId;
    @NotNull(message = "name may not be null")
    private String departmentName;
    private String description;
    private List<Employee> employee;
}
