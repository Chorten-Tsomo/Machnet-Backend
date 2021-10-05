package com.internship.ems.model;


import javafx.beans.binding.MapExpression;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "tb_employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id may not be null")
    private int id;

    @NotNull(message = "first name may not be null")
    @Size(max = 50)
    private String  firstName;

    @NotNull(message = "Last name may not be null")
    @Size(max = 50)
    private String lastName;

    @NotNull(message = "Gender may not be null")
    @Size(max = 6)
    private String gender;

    @NotNull(message = "age may not be null")
    private int age;

    @NotNull(message = "email may not be null")
    @Size(max = 50)
    private String email;

    @NotNull(message = "designation may not be null")
    @Size(max = 50)
    private String  designation;

    @NotNull(message = "hiredate may not be null")
    private Date hireDate;
    private Date resignedDate;

    @Size(max = 100)
    private String address;
}
