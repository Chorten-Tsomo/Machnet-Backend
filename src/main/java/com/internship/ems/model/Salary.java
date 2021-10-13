package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.listener.SalaryListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "salary", schema = "ems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(SalaryListener.class)
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    private int salaryId;


    @NotNull(message = "date may not be null")
    private Date issue_date;


    @NotNull(message = "amount may not be null")
    private float amount;


    private float bonus;

    @OneToOne(mappedBy = "salary")
    @JsonManagedReference(value = "employee-salary")
    private Employee employees;





}
