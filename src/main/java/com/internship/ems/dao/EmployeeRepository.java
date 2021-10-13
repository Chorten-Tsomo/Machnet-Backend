package com.internship.ems.dao;

import com.internship.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeeByDesignation(String designation);


    @Query(value = "SELECT * FROM  Employee WHERE first_name=:name", nativeQuery = true)
    List<Employee> getEmployeeByFirstName(@Param("name") String firstName);

    @Query(value="SELECT e from Employee WHERE e.first_name=:firstName and e.designation=designation")
    List<Employee> getEmployeeByFirstNameAndDesignation(@Param("firstName") String firstName, @Param("designation") String designation);
    @Modifying
    @Query("UPDATE Employee e SET e.age=:age WHERE e.employeeId=:employeeId")
    void updateEmployeeById(@Param("employeeId") int employeeId, @Param("age") int age);

    @Modifying
    @Query("DELETE from Employee e WHERE e.employeeId=:employeeId")
    void deleteEmployeeById(@Param("employeeId") int employeeId);
}
