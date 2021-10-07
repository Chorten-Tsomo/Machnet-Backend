package com.internship.ems.controller;


import com.internship.ems.model.Employee;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/employee")
    public List<Employee> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
        return "Saved!!!";
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeInfo){
        return service.updateEmployee(id, employeeInfo);
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }
}
