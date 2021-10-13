package com.internship.ems.model;




import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.listener.DepartmentListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "department",schema = "ems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(DepartmentListener.class)

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id may not be null")
    private int departmentId;

    @NotNull(message = "department name may not be null")
    @Size(max = 50)
    private String departmentName;

    @Size(max = 100)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",  fetch = FetchType.LAZY)
    @JsonManagedReference(value =  "employee-department")
    private List<Employee> employees;









}
