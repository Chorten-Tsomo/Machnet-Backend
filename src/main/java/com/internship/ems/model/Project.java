package com.internship.ems.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_project", schema = "ems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may noot be null")
    private int projectId;

    @NotNull(message = "project name may not be null")
    @Size(max = 50)
    private String projectName;

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
