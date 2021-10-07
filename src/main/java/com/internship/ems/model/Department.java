package com.internship.ems.model;


import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_department", schema = "ems")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    @NotNull(message = "department name may not be null")
    @Size(max = 50)
    private String departmentName;

    @Column(name = "description")
    @Size(max = 100)
    private String description;

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity" +this+ "will be removed");
    }
    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }


}
