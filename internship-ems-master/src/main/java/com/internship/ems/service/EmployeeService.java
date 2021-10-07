package com.internship.ems.service;


import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.model.Department;
import com.internship.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private DepartmentRepository departmentRepo;

    public Employee addEmployee(Employee employee){
        Department department = departmentRepo.findById(employee.getDepartment().getId()).orElse(null);
        if(null == department){
            department = new Department();
        }
        department.setDepartmentName(employee.getDepartment().getDepartmentName());
        department.setDescription(employee.getDepartment().getDescription());
        employee.setDepartment(department);
        return employeeRepo.save(employee);
    }

    public List<Employee> getAll(){
        List<Employee> result = new ArrayList<>();
        employeeRepo.findAll().forEach(result::add);
        return result;
    }

    public Employee getById(int id){
        return employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);

    }
    public Employee updateEmployee(int id, Employee newEmployee){
        Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setGender(newEmployee.getGender());
        employee.setAge(newEmployee.getAge());
        employee.setEmail(newEmployee.getEmail());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setHireDate(newEmployee.getHireDate());
        employee.setResignedDate(newEmployee.getResignedDate());
        employee.setAddress(newEmployee.getAddress());
        employeeRepo.save(employee);
        return employee;
    }
    public String deleteEmployee(int id){
        employeeRepo.deleteById(id);
        return "Employee deleted!!!" + id;
    }


}


