package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_salary")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    @Column(name = "salary_id")
    private int id;


    @Column(name = "issue_date")
    @NotNull(message = "date may not be null")
    private Date issue_date;

    @Column(name = "amount")
    @NotNull(message = "amount may not be null")
    private float amount;

    @Column(name = "bonus")
    private float bonus;

    @OneToOne(mappedBy = "salary")
    private List<Employee> employeeList;
}
