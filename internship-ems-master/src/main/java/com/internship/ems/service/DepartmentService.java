package com.internship.ems.service;

import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;


    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> getAll(){
        List<Department> result = new ArrayList<>();
        departmentRepo.findAll().forEach(result::add);
        return result;
    }

    public Department getById(int id){
        return departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);

    }
    public Department updateDepartment(int id, Department newDepartment){
        Department department = departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        department.setDepartmentName(newDepartment.getDepartmentName());
        department.setDescription(newDepartment.getDescription());
        departmentRepo.save(department);
        return department;
    }
    public String deleteDepartment(int id){
        departmentRepo.deleteById(id);
        return "Department deleted!!!" + id;
    }
}
