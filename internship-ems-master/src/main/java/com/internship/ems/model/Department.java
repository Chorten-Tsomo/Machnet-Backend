package com.internship.ems.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    private int id;

    @NotNull(message = "department name may not be null")
    @Size(max = 50)
    private String departmentName;

    @Size(max = 100)
    private String description;
}
