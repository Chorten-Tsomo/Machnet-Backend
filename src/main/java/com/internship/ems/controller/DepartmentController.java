package com.internship.ems.controller;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.Department;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;


    @GetMapping(value = "/department")
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public DepartmentDto getDepartmentById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<DepartmentDto>(
                service.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateDepartment/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int id, @RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<DepartmentDto>(
                service.updateDepartment(id, departmentDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id){
        return service.deleteDepartment(id);
    }
}
