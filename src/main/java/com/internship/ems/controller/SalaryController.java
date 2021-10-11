package com.internship.ems.controller;


import com.internship.ems.dto.SalaryDto;
import com.internship.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    private SalaryService service;

    @GetMapping(value = "/salary")
    public List<SalaryDto> getAllSalary(){
        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public SalaryDto getSalaryById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping(value = "/saveSalary")
    public SalaryDto saveSalary(@RequestBody SalaryDto salaryDto){
        return service.saveSalary(salaryDto);

    }

    @PutMapping("/updateSalary/{id}")
    public ResponseEntity<SalaryDto> updateSalary(@PathVariable int id, @RequestBody SalaryDto salaryDto){
        return new ResponseEntity<SalaryDto>( service.updateSalary(id, salaryDto) , HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/deleteSalary/{id}")
    public String deleteSalary(@PathVariable int id){
        return service.deleteSalary(id);
    }
}
