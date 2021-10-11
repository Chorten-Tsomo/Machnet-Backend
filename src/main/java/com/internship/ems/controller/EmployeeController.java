package com.internship.ems.controller;


import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.model.Employee;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/employee")
    public List<EmployeeDto> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@RequestBody int id){
        return service.getById(id);
    }
    @GetMapping("/employeeByFirstName/{firstName}")
    public List<EmployeeDto> findEmployeeByFirstName(@PathVariable String firstName){
        return service.getEmployeeByFirstName(firstName);
    }

    @GetMapping("/getEmployeeByDesignation/{designation}")
    public List<EmployeeDto> getEmployeeByDesignation(@PathVariable String designation){
        return service.findEmployeeByDesignation(designation);
    }
    @GetMapping("/custom/employees/namedquery")
    public List<EmployeeDto> getEmployeeByNamedQuery(@RequestParam("departmentId") int departmentId) {
        return service.getByNamedQuery(departmentId);
    }

    @GetMapping("/custom/employees/typedQuery")
    public List<EmployeeDto> getEmployeeByTypedQuery(@RequestParam("departmentId") int departmentId) {
        return service.getByTypedQuery(departmentId);
    }

    @GetMapping("/custom/employees/criteriaApi")
    public List<EmployeeDto> getEmployeeByJpql(@RequestParam("amount") float amount, @RequestParam("bonus") float bonus) {
        return service.getByCriteriaApi(amount, bonus);
    }


    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(service.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeInfoDto) {
        return new ResponseEntity<>(service.updateEmployee(id, employeeInfoDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    @Transactional
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String  deleteEmployeeById(@PathVariable int id){
        return service.deleteEmployeeById(id);
    }


}
