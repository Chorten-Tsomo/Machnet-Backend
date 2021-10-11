package com.internship.ems.dto;

import com.internship.ems.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;
    @NotNull(message = "No date given")
    private Date issueDate;
    @NotNull
    private float amount;
    private float bonus;
    private Employee employee;
}
