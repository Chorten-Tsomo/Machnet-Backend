package com.internship.ems.service;

import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.mapper.SalaryMapper;
import com.internship.ems.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepo;
    @Autowired
    private SalaryMapper mapper;

    public SalaryDto saveSalary(SalaryDto salaryDto){
        Salary salaryModel = mapper.dtoToModel( salaryDto );
        return  mapper.modelToDto( salaryRepo.save(salaryModel) );
    }

    public List<SalaryDto> getAll(){
        return mapper.modelsToDtos( (List<Salary>) salaryRepo.findAll());
    }

    public SalaryDto getById(int id){
        return mapper.modelToDto( salaryRepo.findById(id).orElseThrow(EntityExistsException::new));

    }
    public SalaryDto updateSalary(int id, SalaryDto newSalaryDto){
        Salary salaryModel = mapper.dtoToModel( newSalaryDto );
        Salary existingSalary = salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        existingSalary.setIssue_date(salaryModel.getIssue_date());
        existingSalary.setAmount(salaryModel.getAmount());
        existingSalary.setBonus(salaryModel.getBonus());
        salaryRepo.save(existingSalary);
        return mapper.modelToDto( existingSalary );
    }
    public String deleteSalary(int id){
        salaryRepo.deleteById(id);
        return "Salary deleted!!!" + id;
    }
}
