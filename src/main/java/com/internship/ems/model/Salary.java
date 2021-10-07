package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tb_salary", schema = "ems")
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

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }
}
