package com.internship.ems.service;

import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.mapper.DepartmentMapper;
import com.internship.ems.model.Department;
import com.internship.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;
     @Autowired
     private DepartmentMapper mapper;


    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        Department departmentModel = mapper.DtoToModel(departmentDto);
        Department departmentSaved = departmentRepo.save(departmentModel);

        return mapper.modelToDto(departmentSaved);
    }

    public List<DepartmentDto> getAll(){
        List<Department> result = new ArrayList<>();
        departmentRepo.findAll().forEach(result::add);
        return mapper.modelsToDtos(result);
    }

    public DepartmentDto getById(int id){
        return mapper.modelToDto(departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new));

    }
    public DepartmentDto updateDepartment(int id, DepartmentDto newDepartmentDto){
        Department departmentModel = mapper.DtoToModel(newDepartmentDto);
        Department department = departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        department.setDepartmentName(departmentModel.getDepartmentName());
        department.setDescription(departmentModel.getDescription());
        departmentRepo.save(department);
        return mapper.modelToDto(department);
    }
    public String deleteDepartment(int id){
        departmentRepo.deleteById(id);
        return "Department deleted!!!" + id;
    }
}
