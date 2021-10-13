package com.internship.ems.mapper;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.Department;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto modelToDto(Department department);
    List<DepartmentDto> modelsToDtos(List<Department> departments);

    @InheritInverseConfiguration
    Department DtoToModel(DepartmentDto departmentDto);

}
