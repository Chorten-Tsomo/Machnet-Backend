package com.internship.ems.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_project")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may noot be null")
    private int id;

    @NotNull(message = "project name may not be null")
    @Size(max = 50)
    private String projectName;

    @Size(max = 100)
    private String description;

}
