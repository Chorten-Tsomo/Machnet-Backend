package com.internship.ems.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "tb_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id may not be null")
    @Column(name = "employee_id")
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "first name may not be null")
    @Size(max = 50)
    private String  firstName;


    @Column(name = "last_name")
    @NotNull(message = "Last name may not be null")
    @Size(max = 50)
    private String lastName;

    @Column(name = "gender")
    @NotNull(message = "Gender may not be null")
    @Size(max = 6)
    private String gender;


    @Column(name = "age")
    @NotNull(message = "age may not be null")
    private int age;

    @Column(name = "email")
    @NotNull(message = "email may not be null")
    @Size(max = 50)
    private String email;

    @Column(name = "designation")
    @NotNull(message = "designation may not be null")
    @Size(max = 50)
    private String  designation;

    @Column(name = "hire_date")
    @NotNull(message = "hiredate may not be null")
    private Date hireDate;

    @Column(name = "resigned_date")
    private Date resignedDate;

    @Column(name = "address")
    @Size(max = 100)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "department_id"),name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private Salary salary;





}
