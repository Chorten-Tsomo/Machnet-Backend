package com.internship.ems.model;





import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.listener.EmployeeListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Table(name = "tb_employee", schema = "ems", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})} )
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EmployeeListener.class)
@NamedQuery(name="Employee.getEmployeeByNamedQuery", query ="select e from Employee e where e.department.department_id=:id" )
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id may not be null")
    @Column(name = "employee_id")
    private int employeeId;

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
    @Size(max = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;


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

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference(value = "employee-department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salary_id")
    @JsonBackReference(value = "employee-salary")
    public Salary salary;

    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }










}
