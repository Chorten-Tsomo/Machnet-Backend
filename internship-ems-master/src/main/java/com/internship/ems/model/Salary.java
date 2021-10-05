package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tb_salary")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    private int id;

    @NotNull(message = "date may not be null")
    private Date issue_date;

    @NotNull(message = "amount may not be null")
    private float amount;
    private float bonus;
}
