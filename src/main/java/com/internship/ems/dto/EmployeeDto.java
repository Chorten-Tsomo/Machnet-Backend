package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Department;
import com.internship.ems.model.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotNull(message = "FirstName may not be null")
    private String firstName;

    @NotNull(message = "Lastname may not be null")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Age may not be null")
    private int age;

    @Email
    @NotNull(message = "Email may not be null")
    private String email;

    @NotNull(message = "Designation may not be null")
    private String designation;

    private Date hireDate;

    private Date resignedDate;

    private String address;

    @JsonBackReference(value = "employee-department")
    private Department department;

    @JsonBackReference(value = "employee-salary")
    public Salary salary;
}
