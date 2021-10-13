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
@Table(name = "employee", schema = "ems", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})} )
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EmployeeListener.class)
@NamedQuery(name="Employee.getEmployeeByNamedQuery", query ="select e from Employee e where e.department.department_id=:id" )
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id may not be null")
    private int employeeId;


    @NotNull(message = "first name may not be null")
    @Size(max = 50)
    private String  firstName;



    @NotNull(message = "Last name may not be null")
    @Size(max = 50)
    private String lastName;


    @NotNull(message = "Gender may not be null")
    @Size(max = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;



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

    @ManyToOne
    @JoinColumn(name = "departmentId")
    @JsonBackReference(value = "employee-department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salaryId")
    @JsonBackReference(value = "employee-salary")
    public Salary salary;

    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }










}
