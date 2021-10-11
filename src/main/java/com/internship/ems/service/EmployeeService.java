package com.internship.ems.service;


import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dao.EmployeeDao;
import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.mapper.EmployeeMapper;
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
    private EmployeeMapper mapper;

    @Autowired
    private EmployeeDao employeeDao;


    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employeeModel = mapper.DtoToModel(employeeDto);
        Employee employeeSaved = employeeRepo.save(employeeModel);
        return mapper.modelToDto(employeeSaved);
    }
    public List<EmployeeDto> getAll(){
        List<Employee> employeesList = (List<Employee>) employeeRepo.findAll();

        return mapper.modelsToDtos(employeesList);
    }



    public List<EmployeeDto> getEmployeeByFirstName(String firstName){
        return mapper.modelsToDtos(employeeRepo.getEmployeeByFirstName(firstName));
    }
    public List<EmployeeDto> findEmployeeByDesignation(String designation){
        return mapper.modelsToDtos(employeeRepo.findEmployeeByDesignation(designation));
    }

    public EmployeeDto getById(int id){
        return mapper.modelToDto(employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    public List<EmployeeDto> getByNamedQuery(int departmentId) {
        return mapper.modelsToDtos(employeeDao.getEmployeeByNamedQuery(departmentId));
    }

    public List<EmployeeDto> getByTypedQuery(int departmentId) {
        return mapper.modelsToDtos(employeeDao.getEmployeeByTypedQuery(departmentId));
    }

    public List<EmployeeDto> getByCriteriaApi(float amount, float bonus) {
        return mapper.modelsToDtos(employeeDao.getEmployee(amount, bonus));
    }
    public EmployeeDto updateEmployee(int id, EmployeeDto newEmployeeDto){
        Employee employeeModel = mapper.DtoToModel(newEmployeeDto);
        Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());
        employee.setGender(employeeModel.getGender());
        employee.setAge(employeeModel.getAge());
        employee.setEmail(employeeModel.getEmail());
        employee.setDesignation(employeeModel.getDesignation());
        employee.setHireDate(employeeModel.getHireDate());
        employee.setResignedDate(employeeModel.getResignedDate());
        employee.setAddress(employeeModel.getAddress());
        employeeRepo.save(employee);
        return mapper.modelToDto(employee);
    }
    public String deleteEmployee(int id){
        employeeRepo.deleteById(id);
        return "Employee deleted!!!" + id;
    }

    public String deleteEmployeeById(int id){
        employeeRepo.deleteEmployeeById(id);

        return "ID: "+id+" Deleted";
    }


}


