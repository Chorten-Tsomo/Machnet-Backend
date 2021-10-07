package com.internship.ems.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_project", schema = "ems")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    @Column(name = "project_id")
    private int id;

    @Column(name = "project_name")
    @NotNull(message = "project name may not be null")
    @Size(max = 50)
    private String projectName;

    @Column(name = "project_description")
    @Size(max = 100)
    private String description;

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }

}
