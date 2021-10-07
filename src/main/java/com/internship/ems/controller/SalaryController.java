package com.internship.ems.controller;



import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    private SalaryService service;

    @GetMapping(value = "/salary")
    public List<Salary> getAllSalary(){
        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public Salary getSalaryById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping(value = "/saveSalary")
    public String saveSalary(@RequestBody Salary salary){
        service.saveSalary(salary);
        return "Saved!!!";
    }

    @PutMapping(value = "/updateSalary/{id}")
    public Salary updateSalary(@PathVariable int id, @RequestBody Salary salaryInfo){
        return service.updateSalary(id, salaryInfo);
    }

    @DeleteMapping(value = "/deleteSalary/{id}")
    public String deleteSalary(@PathVariable int id){
        return service.deleteSalary(id);
    }
}
