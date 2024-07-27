end point to test db - 
http://localhost:8080/api/employees-and-departments


CREATE TABLE departments (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

INSERT INTO departments (id, name) VALUES (1, 'HR'), (2, 'Engineering'), (3, 'Sales');

INSERT INTO employees (id, name, department_id) VALUES
(1, 'John Doe', 1),
(2, 'Jane Smith', 2),
(3, 'Jim Brown', 3),
(4, 'Jake White', 2);

<--------- Create store proc from here --------> 

CREATE PROCEDURE Proc_GetEmployeesAndDepartments
AS
BEGIN
    -- Query for Employees
    SELECT * FROM employees;

    -- Query for Departments
    SELECT * FROM departments;
END
