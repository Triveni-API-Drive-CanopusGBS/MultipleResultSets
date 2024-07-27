package com.example.demo;

import java.util.List;

class EmployeeDepartmentResult {
    private List<Employees> employees;
    private List<Department> departments;
	public List<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public EmployeeDepartmentResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDepartmentResult(List<Employees> employees, List<Department> departments) {
		super();
		this.employees = employees;
		this.departments = departments;
	}

   
}