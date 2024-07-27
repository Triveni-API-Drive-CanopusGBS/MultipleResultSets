package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDepartmentService {

    @Autowired
    private EmployeeDepartmentRepository repository;

    public EmployeeDepartmentResult getEmployeesAndDepartments() {
        return repository.getEmployeesAndDepartments();
    }
}

