package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDepartmentController {

    @Autowired
    private EmployeeDepartmentService service;

    @GetMapping("/api/employees-and-departments")
    public EmployeeDepartmentResult getEmployeesAndDepartments() {
        return service.getEmployeesAndDepartments();
    }
}
