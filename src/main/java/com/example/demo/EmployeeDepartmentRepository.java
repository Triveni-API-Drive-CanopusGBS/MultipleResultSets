package com.example.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeeDepartmentResult getEmployeesAndDepartments() {
        return jdbcTemplate.execute(new ConnectionCallback<EmployeeDepartmentResult>() {
            @Override
            public EmployeeDepartmentResult doInConnection(Connection connection) throws SQLException {
                try (CallableStatement callableStatement = connection.prepareCall("{call Proc_GetEmployeesAndDepartments()}")) {
                    boolean hasResults = callableStatement.execute();
                    EmployeeDepartmentResult result = new EmployeeDepartmentResult();

                    if (hasResults) {
                        result.setEmployees(mapEmployees(callableStatement.getResultSet()));
                    }

                    if (callableStatement.getMoreResults()) {
                        result.setDepartments(mapDepartments(callableStatement.getResultSet()));
                    }

                    return result;
                }
            }
        });
    }

    private static List<Employees> mapEmployees(ResultSet rs) throws SQLException {
        List<Employees> employees = new ArrayList<>();
        while (rs.next()) {
            Employees employee = new Employees();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartmentId(rs.getInt("department_id"));
            employees.add(employee);
        }
        return employees;
    }

    private static List<Department> mapDepartments(ResultSet rs) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setName(rs.getString("name"));
            departments.add(department);
        }
        return departments;
    }
}

