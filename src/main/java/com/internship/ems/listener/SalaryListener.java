package com.internship.ems.listener;

import com.internship.ems.model.Salary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class SalaryListener {
private static Log log = LogFactory.getLog(EmployeeListener.class);
    @PrePersist
    private void beforeSave(Salary salary) {
        log.info("On the way to adding salary data");
    }

    @PreUpdate
    private void beforeUpdate(Salary salary) {
        log.info("Updating salary data: " + salary.getSalaryId());
    }

    @PreRemove
    private void beforeDelete(Salary salary) {
        log.info("Deleting salary data: " + salary.getSalaryId());
    }

    @PostPersist
    private void afterSave(Salary salary) {
        log.info("Save process completed for salary: " + salary.getSalaryId());
    }

    @PostUpdate
    private void afterUpdate(Salary salary) {
        log.info("Update process completed for salary: " + salary.getSalaryId());
    }

    @PostRemove
    private void afterDelete(Salary salary) {
        log.info("Delete process completed for salary: " + salary.getSalaryId());
    }

    @PostLoad
    private void afterLoad(Salary salary) {
        log.info("Salary loaded from database: " + salary.getSalaryId());
    }


}
