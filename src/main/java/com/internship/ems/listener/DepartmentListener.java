package com.internship.ems.listener;

import com.internship.ems.model.Department;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;



public class DepartmentListener {
    private static Log log = LogFactory.getLog(EmployeeListener.class);
    @PrePersist
    private void beforeSave(Department department) {
        log.info("On the way to save department detail");
    }

    @PreUpdate
    private void beforeUpdate(Department department) {
        log.info("Updating department:  " + department.getDepartmentId());
    }

    @PreRemove
    private void beforeDelete(Department department) {
        log.info("On the way to delete department: " + department.getDepartmentId());
    }

    @PostPersist
    private void afterSave(Department department) {
        log.info("Done saving department details: " + department.getDepartmentId());
    }

    @PostUpdate
    private void afterUpdate(Department department) {
        log.info("Done updating department:  " + department.getDepartmentId());
    }

    @PostRemove
    private void afterDelete(Department department) {
        log.info("Deleted successfully department details: " + department.getDepartmentId());
    }

    @PostLoad
    private void afterLoad(Department department) {
        log.info("Department loaded from database: " + department.getDepartmentId());
    }
}
