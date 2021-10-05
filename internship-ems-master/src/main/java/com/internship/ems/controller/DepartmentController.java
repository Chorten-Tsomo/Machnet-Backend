package com.internship.ems.controller;

import com.internship.ems.model.Department;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping(value = "/department")
    public List<Department> getAllDepartment(){
        return service.getAll();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping(value = "/saveDepartment")
    public String saveDepartment(@RequestBody Department department){
        service.saveDepartment(department);
        return "Saved!!!";
    }

    @PutMapping(value = "/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department departmentInfo){
        return service.updateDepartment(id, departmentInfo);
    }

    @DeleteMapping(value = "/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id){
        return service.deleteDepartment(id);
    }
}
