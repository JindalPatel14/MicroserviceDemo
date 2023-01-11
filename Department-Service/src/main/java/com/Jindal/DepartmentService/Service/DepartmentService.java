package com.Jindal.DepartmentService.Service;

import com.Jindal.DepartmentService.Repository.DepartmentRepository;
import com.Jindal.DepartmentService.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public Department saveDepartment(Department department) {
        log.info("Inside SaveDepartment method in departmentService");
        return repo.save(department);

    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside finddepartmentById method of DepartmentService");
        return repo.findByDepartmentId(departmentId);
    }
}
