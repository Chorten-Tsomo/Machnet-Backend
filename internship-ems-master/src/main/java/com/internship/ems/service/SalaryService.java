package com.internship.ems.service;

import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepo;

    public Salary saveSalary(Salary salary){
        return salaryRepo.save(salary);
    }

    public List<Salary> getAll(){
        List<Salary> result = new ArrayList<>();
        salaryRepo.findAll().forEach(result::add);
        return result;
    }

    public Salary getById(int id){
        return salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);

    }
    public Salary updateSalary(int id, Salary newSalary){
        Salary salary = salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        salary.setIssue_date(newSalary.getIssue_date());
        salary.setAmount(newSalary.getAmount());
        salary.setBonus(newSalary.getBonus());
        salaryRepo.save(salary);
        return salary;
    }
    public String deleteSalary(int id){
        salaryRepo.deleteById(id);
        return "Salary deleted!!!" + id;
    }
}
