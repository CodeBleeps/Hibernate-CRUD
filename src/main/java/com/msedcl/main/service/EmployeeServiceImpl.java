package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;
import com.msedcl.main.repository.EmployeeRepositoryImpl;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EmployeeServiceImpl implements EmployeeService {
	private static final EmployeeRepository EMPLOYEE_REPOSITORY = new  EmployeeRepositoryImpl();  

	@Override
	public Employee addNewEmployee(Employee employee) {		
		return EMPLOYEE_REPOSITORY.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return EMPLOYEE_REPOSITORY.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeebyEmployeeId(int employeeId) {
		return EMPLOYEE_REPOSITORY.getEmployeebyEmployeeId(employeeId);
	}

	@Override
	public Employee deleteEmployeebyEmployeeId(int employeeId) {
		return EMPLOYEE_REPOSITORY.deleteEmployeebyEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return EMPLOYEE_REPOSITORY.getAllEmployees();
	}
	
	@Override
	public List<Employee> getEmployeebyEmployeeName(String name) {
		return EMPLOYEE_REPOSITORY.getEmployeebyEmployeeName(name);
	}

	@Override
	public long getCountofEmployees() {
		return EMPLOYEE_REPOSITORY.getCountofEmployees();
	}

	@Override
	public double maxSalaryDrawn() {
		return EMPLOYEE_REPOSITORY.maxSalaryDrawn();
	}

}
