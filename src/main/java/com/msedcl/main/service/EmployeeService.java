package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Employee;

public interface EmployeeService {
	Employee addNewEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployeebyEmployeeId(int employeeId);
	Employee deleteEmployeebyEmployeeId(int employeeId);
	List<Employee> getAllEmployees();
	List<Employee> getEmployeebyEmployeeName(String name);
}
